/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintprojtest;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;


public class PaintProjTest extends Application{

   
    public static void main(String[] args) {
     
        
        
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
            
Parent gp= FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
primaryStage.setScene( new Scene(gp));
primaryStage.show();
       
    }
    
}

