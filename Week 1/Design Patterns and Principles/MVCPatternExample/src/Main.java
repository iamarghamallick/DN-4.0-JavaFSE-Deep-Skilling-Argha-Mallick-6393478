public class Main {
    public static void main(String[] args) {

        // Student model
        Student student = new Student();
        student.setName("Argha Mallick");
        student.setId("6393478");
        student.setGrade("B");

        // Create the View: The part of the UI that will display the data
        StudentView view = new StudentView();

        // Create the Controller: The link between the Model and the View
        StudentController controller = new StudentController(student, view);

        // Display the initial data
        System.out.println("Displaying initial student details:");
        controller.updateView();

        System.out.println("Updating student's grade...");

        // Update the model data using the controller
        controller.setStudentGrade("A+");

        // Display the updated data
        System.out.println("Displaying updated student details:");
        controller.updateView();
    }
}