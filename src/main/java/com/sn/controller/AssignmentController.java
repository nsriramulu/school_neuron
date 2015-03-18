package com.sn.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sn.common.WebContextHolder;
import com.sn.common.utils.SnDateUtils;
import com.sn.constants.ApplicationConstants;
import com.sn.entity.ClassSubjectTeacher;
import com.sn.entity.Post;
import com.sn.entity.User;
import com.sn.service.PostService;
import com.sn.utils.JSONUtils;
import com.sn.vo.UserProfileVO;
/**
 * The Class UserSelfServiceController is the major controller for self-service module.
 */
@Controller
@RequestMapping(value = "/sn")
public class AssignmentController {

	@Value("${docTempPath}")
	private String docTempPath;

	@Value("${docRealPath}")
	private String docRealPath;
	
	@Autowired
	private PostService postService;

	@RequestMapping(value = "/assignments", method = RequestMethod.GET)
	public String getAssignmentsPage(ModelMap model,HttpSession session) {
		String view = "assignment";
		try{
			session.removeAttribute("docName");
			List<Integer> classIds = new ArrayList<Integer>();
			UserProfileVO userProfile = WebContextHolder.get().getLoggedInUserProfile();
			User user = userProfile.getUser();
			List<ClassSubjectTeacher> classSubjectTeachers = userProfile.getClasses();
			if(classSubjectTeachers!=null){
				for(ClassSubjectTeacher classObj : userProfile.getClasses()){
					classIds.add(classObj.getClassesByClassId().getId());
				}
			}
			List<Post> posts = null;
			if(StringUtils.equalsIgnoreCase(ApplicationConstants.TEACHER_ROLE,user.getRole())){
				session.setAttribute("classSubjectTeachers", classSubjectTeachers);//getUniqueClasses(classSubjectTeachers)
				posts = postService.getPostsForTeacher(WebContextHolder.get().getLoggedInUser().getUid(), classIds,ApplicationConstants.POSTS_FOR_ASSIGNMENT_PAGE);
			}
			else if(StringUtils.equalsIgnoreCase(ApplicationConstants.PARENT_ROLE,user.getRole()) || StringUtils.equalsIgnoreCase(ApplicationConstants.STUDENT_ROLE,user.getRole())){
				posts = postService.getPostsForStudentOrParent(user.getClassId(),ApplicationConstants.POST_TYPE_ASSIGNMENT);
				view = "student_assignment";
			}
			else if(StringUtils.equalsIgnoreCase(ApplicationConstants.PRINCIPAL_ROLE,user.getRole())){
				posts = postService.getPostsForPrincipal();
			}
			model.put("posts", posts);
		}
		catch(Exception e){
			view = "error";
		}
		return view;
	}
	
	@RequestMapping(value = "uploadDoc", method = RequestMethod.POST, headers={"content-type=multipart/form-data"})
	//@RequestParam("document") CommonsMultipartFile file
	public @ResponseBody String uploadPhoto(MultipartHttpServletRequest request,
			ModelMap modelMap,HttpSession session){
		session.removeAttribute("docName");
		String response = JSONUtils.getSuccessJSONResponse("Document uploaded succesfully");
		 Iterator<String> iterator = request.getFileNames();
	     MultipartFile file = request.getFile(iterator.next());
		String fileName = "";
		File tenantDir = new File(docTempPath);
		if (!tenantDir.exists()) {
			tenantDir.mkdir();
		}
		 if (!file.isEmpty()){
			 String name = file.getOriginalFilename();
			 int index = name.lastIndexOf(".");
			 String ext  = name.substring(index);
			 fileName = StringUtils.split(name, ".")[0]+"_"+SnDateUtils.getCurrentTimeStamp()+ext;
				 try{
					 File out = new File ( docTempPath+File.separator+fileName);
					 byte[] bytes = file.getBytes();
					 BufferedOutputStream stream =	new BufferedOutputStream( new FileOutputStream( out ));
					 stream.write(bytes);
					 stream.close();
				 }
				 catch (Exception e){
					 response = JSONUtils.getErrorJSONRresponse("Failed to upload");
					 e.printStackTrace();
				 }
		 }
		modelMap.addAttribute("selectedMenu", "profile");
		session.setAttribute("docName", fileName);
		return response;
	}
	
	@RequestMapping(value = "/downloadDoc", method = RequestMethod.GET)
    public void downloadnotepadfile(HttpServletRequest request,
            HttpServletResponse response,@RequestParam String fileName) {
        try {
            File f = new File(docRealPath+File.separator+fileName);
            response.setContentType("application/txt");
            response.setContentLength(new Long(f.length()).intValue());
            response.setHeader("Content-Disposition",
                    "attachment; filename="+fileName);
            FileCopyUtils.copy(new FileInputStream(f),
                    response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@RequestMapping(value = "/submitAssignment", method = RequestMethod.POST)
	public @ResponseBody String submitAssignment(ModelMap model,@RequestParam(value = "assignmentTitle") String title,
			@RequestParam(value = "assignmentDesc") String desc,
			@RequestParam(value = "assignmentClass") String classId,
			@RequestParam(value = "assignmentDate") String date,
			@RequestParam(value = "type") String type, HttpSession session) {
		String response = "";
		Object object = session.getAttribute("docName");
		String fileName = "";
		if(object != null){
			session.removeAttribute("docName");
			fileName = (String)object;
			try {
				File destDir = new File(docRealPath);
				if (!destDir.exists()) {
					destDir.mkdir();
				}
				FileUtils.copyFileToDirectory(new File(docTempPath+File.separator+fileName), destDir);
				FileUtils.forceDelete(new File(docTempPath+File.separator+fileName));
			} catch (IOException e) {
				e.printStackTrace();
				response = JSONUtils.getErrorJSONRresponse("Attachment not found");
			}
		}
		if(StringUtils.isBlank(response)){
			response = postService.submitEvent(title,desc, date,null, Integer.parseInt(classId), type,fileName);
		}
		return response;
	}
	
	
	@RequestMapping(value = "/submitOnlineAssignment", method = RequestMethod.POST)
	public @ResponseBody String submitOnlineAssignment(ModelMap model,@RequestParam(value = "postId") Integer postId,
			@RequestParam(value = "comment") String comment, 
			@RequestParam(value = "submittedCount") Integer submittedCount,HttpSession session) {
		String response = "";
		Object object = session.getAttribute("docName");
		String fileName = "";
		if(object != null){
			session.removeAttribute("docName");
			fileName = (String)object;
			try {
				File destDir = new File(docRealPath);
				if (!destDir.exists()) {
					destDir.mkdir();
				}
				FileUtils.copyFileToDirectory(new File(docTempPath+File.separator+fileName), destDir);
				FileUtils.forceDelete(new File(docTempPath+File.separator+fileName));
			} catch (IOException e) {
				e.printStackTrace();
				response = JSONUtils.getErrorJSONRresponse("Attachment not found");
			}
		}
		if(StringUtils.isBlank(response)){
			response = postService.submitOnlineAssignment(postId,comment,fileName,submittedCount);
		}
		return response;
	}
}
