package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.Api.ApiException;
import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.CourseRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

        private final CourseRepository courseRepository;
        private final TeacherRepository teacherRepository;
        public List<Course> getAllCourses(){
            return courseRepository.findAll();
        }

        public void addCourse(Course course){
            courseRepository.save(course);
        }


        public String updateCourse(Integer id , Course course){
            Course oldCourse = courseRepository.findCourseById(id);
            if(oldCourse == null) throw new ApiException("Course not found");
            course.setId(id);
            courseRepository.save(course);
            return "Course updated";
        }

        public String deleteCourse(Integer id){
            Course course = courseRepository.findCourseById(id);
            if(course == null) throw new ApiException("Course not found");
            courseRepository.delete(course);
            return "Course deleted";
        }

        public String assign(Integer teacherid, Integer courseid){
            Course course = courseRepository.findCourseById(courseid);
            if(course == null) throw new ApiException("Course not found");
            Teacher teacher = teacherRepository.findTeacherById(teacherid);
            if(teacher == null) throw  new ApiException("Teacher not found");
            course.setTeacher(teacher);
            courseRepository.save(course);
            return "Course assigned to "+teacher.getName();
        }

        public Course courseDetails(Integer id){
            Course course = courseRepository.findCourseById(id);
            if(course == null) throw new ApiException("Course not found");
            return course;
        }

        public String TeacherName(Integer id){
            Course course =courseRepository.findCourseById(id);
            if(course == null) throw new ApiException("Course not found");
            return course.getTeacher().getName();
        }
}
