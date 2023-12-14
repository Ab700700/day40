package com.example.schoolmanagement.Contorller;

import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sm/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getAllCourses());
    }

    @PostMapping("/add/")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body("Course added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id , @RequestBody @Valid Course course){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.updateCourse(id,course));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.deleteCourse(id));
    }

    @PutMapping("/assign/{tid}/{cid}")
    public ResponseEntity assign(@PathVariable Integer tid,@PathVariable Integer cid){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.assign(tid,cid));
    }

    @GetMapping("/course/{id}")
    public ResponseEntity courseDetials(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.courseDetails(id));
    }

    @GetMapping("/teachername/{courseid}")
    public ResponseEntity teacherName(@PathVariable Integer courseid){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.TeacherName(courseid));
    }



}
