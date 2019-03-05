package com.three2one.assessment.util.rest;

public class ResourceConstant {
    public static final String STUDENT_RESOURCE = "/student";
    public static final String STUDENT_REGISTER = "/register";
    public static final String STUDENT_LOGIN = "/login";

    public static final String COURSE_RESOURCE = "/course";
    public static final String COURSE_CREATE = "/create";
    public static final String AVAILABLE_COURSES = "/{studentId}/available";
    public static final String REGISTERED_COURSES = "/{studentId}/registered";
    public static final String COURSE_REGISTER = "/register";
    public static final String COURSE_UNREGISTER = "/unregister";
}
