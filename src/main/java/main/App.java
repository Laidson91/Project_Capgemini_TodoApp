package main;

import controller.ProjectController;
import controller.TaskController;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.Project;
import model.Task;
import util.ConnectionFactory;

public class App {
   

    public static void main(String[] args) throws SQLException {
        
        //        ProjectController projectController = new ProjectController();
        
//        Project project = new Project();
//        project.setName("Projeto teste");
//        project.setDescription("description");
//        projectController.save(project);
        
       ProjectController projectController = new ProjectController();
        
        Project project = new Project();
        project.setId(2);
        project.setName("Novo projeto");
        project.setDescription("description 1");
        projectController.update(project);
        
        List<Project> projects = projectController.getAll();
        System.out.println("Total de projetos = " + projects.size());
        
        projectController.removeById(2);
             
        
        /*project.setName("Novo nome do projeto");
        projectController.update(project);
        
        List<Project> projetc = projectController.getAll();
        System.out.println("Total de projetos = " + project.size());
*/
        TaskController taskController = new TaskController();
        
        Task task = new Task();
        task.setIdProject(2);
        task.setName("Criar as telas da aplicação");
        task.setDescription("Devem ser criadas telas para os cadastros");
        task.setNotes("Sem notas");
        task.setIsCompleted(false);
        task.setDeadline(new Date());
        
        taskController.save(task);
        
        task.setName("Alterar telas da aplicação");
        taskController.update(task);
        List<Task> tasks = taskController.getAll(1);
        System.out.println("Total de tarefas" + tasks.size());
    }
}
