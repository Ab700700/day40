package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.Api.ApiException;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public String updateTeacher(Integer id, Teacher teacher){
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if(teacher1 == null) throw new ApiException("Teacher not found");
        teacher.setId(id);
        teacherRepository.save(teacher);
        return "Teacher updated";
    }

    public String deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher == null) throw  new ApiException("Teacher not found");
        teacherRepository.delete(teacher);
        return "Teacher deleted";
    }

    public Teacher teacherDetails(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher== null) throw new ApiException("Teacher not found");
        return teacher;
    }

}
