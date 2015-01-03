package com.sn.dao;

import java.util.List;

import com.sn.entity.ClassSubjectTeacher;

public interface ClassDAO {
List<ClassSubjectTeacher> getClassesByUserId(Integer userId);
}
