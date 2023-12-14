package com.example.schoolmanagement.Contorller;


import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sm/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getAllTeachers());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("Teacher added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id , @RequestBody @Valid Teacher teacher){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.updateTeacher(id,teacher));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.deleteTeacher(id));
    }

    @GetMapping("/teacherdetails/{id}")
    public ResponseEntity teacherDetails(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.teacherDetails(id));
    }

}
