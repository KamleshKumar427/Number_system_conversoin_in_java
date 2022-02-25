1. Open IntelliJ IDEA
     Also Assuming that Java is already configured in intellij.
2. Click open the folder "Conversion" as Intellij Project.
3. then include javaFx libraray as external library in the project.(Configuration given below) 
4. Add VM options. (Configuration given below)
5. Run main method from Conversion class.
6. play

///How to configure javafx in IntelliJ IDEA///

1. Download javafx from gluonhq
2. open intelliJ and open any project
3. press ctrl+alt+shift+u
4. go to global libraries
5. add location of lib folder in the downloaded javafx files.
6. whenever you make javafx project, press ctrl+alt+shit+u, go to global libraries, right click javafx and select add to modules, then add module-info.java file to project.

///How to add VM option in IntelliJ IDEA///
1. Go to run tab.
2. Go to Edit Configuration.
3. Go to Modify options.
4. then add <--module-path "Your JavaFx SDK lib directory" --add-modules javafx.controls,javafx.fxml> at the     place of "VM Option".
5. then press apply and ok.
