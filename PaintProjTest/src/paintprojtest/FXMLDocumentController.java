/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintprojtest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import static java.lang.Math.abs;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author gabe
 */
public class FXMLDocumentController implements Initializable {
 
    private TextField bSize;
    private Canvas canvas;
    
    boolean brushSelected = false;
    boolean eraserSelected = false;
    boolean paintBucketSelected= false;
    boolean lineSelected= false;
    boolean rectSelected= false;
    boolean circleSelected= false;
    boolean textSelected= false;
    
    double srtX=0, srtY=0;
    double endX=0, endY=0;

    GraphicsContext brushTool;
    GraphicsContext eraserTool;
    GraphicsContext paintBucketTool;
    GraphicsContext rectTool;
    GraphicsContext lineTool;
    GraphicsContext circleTool;
     GraphicsContext textTool;
    
    Rectangle rect = new Rectangle();
Circle circle = new Circle();
     
    
    private ColorPicker colorPicker;
    private TextField currentStroke;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }    
  
    private void brushSelected(ActionEvent event) {
        
        
        eraserSelected= false;
        paintBucketSelected= false; 
        lineSelected = false;
        rectSelected= false;
        circleSelected= false;
        brushSelected= true;
    
        
        brushTool = canvas.getGraphicsContext2D();   
        
        canvas.setOnMousePressed (e -> {     
      
        brushTool.setStroke(colorPicker.getValue());
        brushTool.beginPath();
        //brushTool.lineTo(e.getX(),e.getY());
        brushTool.stroke();
        
        double size = Double.parseDouble(currentStroke.getText());
        brushTool.setLineWidth(size);
        
        });
        
        canvas.setOnMouseDragged(e->{

            if (brushSelected && !currentStroke.getText().isEmpty()){
        brushTool.setStroke(colorPicker.getValue());
        double size = Double.parseDouble(currentStroke.getText());
        double x = e. getX() - size /2;
        double y = e. getY() - size /2;
        brushTool.lineTo(x,y);
        brushTool.stroke();
        brushTool.setLineWidth(size);
        }
            
        });
        
        canvas.setOnMouseReleased(e->{
      
         brushTool.beginPath();
       //brushTool.closePath();
        });
        
    }


    private void eraserSelected(ActionEvent event) {
        
      
        
         
        eraserSelected= true;
        paintBucketSelected= false; 
        lineSelected = false;
        rectSelected= false;
        circleSelected= false;
        brushSelected= false;
     
        eraserTool = canvas.getGraphicsContext2D();
      
        canvas.setOnMousePressed (e -> {
     
        eraserTool.setStroke(Color.WHITE);
        eraserTool.beginPath();
        //brushTool.lineTo(e.getX(),e.getY());
       eraserTool.stroke();
        
        double size = Double.parseDouble(currentStroke.getText());
        eraserTool.setLineWidth(size);
        });
        
        canvas.setOnMouseDragged(e->{
            
            
            if (eraserSelected && !currentStroke.getText().isEmpty()){
        eraserTool.setStroke(Color.WHITE);
        double size = Double.parseDouble(currentStroke.getText());
        double x = e. getX() - size /2;
        double y = e. getY() - size /2;
        eraserTool.lineTo(x,y);
        eraserTool.stroke();
        eraserTool.setLineWidth(size);
        }
             
        
        });
        
        canvas.setOnMouseReleased(e->{
         
         brushTool.beginPath();
       //  brushTool.closePath();
        });

    }

    private void twoPx(ActionEvent event) {
        currentStroke.setText("2");
    }

    private void fivePx(ActionEvent event) {
        currentStroke.setText("5");
    }

    private void eightPx(ActionEvent event) {
        currentStroke.setText("8");
    }
    
    private void tenPx(ActionEvent event) {
        currentStroke.setText("10");
    }
    

    private void paintBucketSelected(ActionEvent event) {
       
        paintBucketSelected= true;
        brushSelected= false;
        eraserSelected= false;
        lineSelected = false;
        rectSelected= false;
        circleSelected= false;
        
        paintBucketTool = canvas.getGraphicsContext2D();
        
        canvas.setOnMouseDragged(e -> {
        
       
       if (paintBucketSelected && !currentStroke.getText().isEmpty()){
            paintBucketTool.setFill(colorPicker.getValue());
           
            
        }
        });
    }

    private void lineSelected(ActionEvent event) {
        
        brushSelected= false; 
        lineSelected = true;
        eraserSelected= false;
        paintBucketSelected= false; 
        rectSelected= false;
        circleSelected= false;
           
        lineTool = canvas.getGraphicsContext2D();
        
        canvas.setOnMousePressed(e -> {
            
        srtX=e.getX();
        srtY=e.getY();
     
         
        lineTool.setStroke(colorPicker.getValue());
        
        });
        
        canvas.setOnMouseReleased(e -> {
        endX=e.getX();
        endY=e.getY();
   
        double size = Double.parseDouble(currentStroke.getText());
        double x = e. getX() - size /2;
        double y = e. getY() - size /2;
       
        if (lineSelected && !currentStroke.getText().isEmpty()){
           
            lineTool.strokeLine( srtX,srtY,endX,endY);
            lineTool.setLineWidth(size);
            lineTool.setStroke(colorPicker.getValue());
            
        }
        });
    }

    private void rectSelected(ActionEvent event) {
       
        rectSelected= true;
        brushSelected= false;
        eraserSelected= false;
        paintBucketSelected= false; 
        lineSelected = false;
        circleSelected= false;
          
        rectTool = canvas.getGraphicsContext2D();
        
        canvas.setOnMousePressed(e -> {
        srtX=e.getX();
        srtY=e.getY();
        rect.setX(e.getX());
        rect.setY(e.getY());
        rectTool.setStroke(colorPicker.getValue());
        });
        
        canvas.setOnMouseReleased(e -> {
        endX=e.getX();
        endY=e.getY();
        
        double size = Double.parseDouble(currentStroke.getText());
        double w= abs( srtX - endX);
        if (w < 0)
        w = w * (-1);
        double h= abs(srtY-endY );
        if (h < 0)
        h = h * (-1);
        double x = e. getX() - size /2;
        double y = e. getY() - size /2;
        
        if (rectSelected && !currentStroke.getText().isEmpty()){
            rectTool.setFill(colorPicker.getValue());
            rectTool.setLineWidth(size);
            //rectTool.strokeRect(srtX,srtY,w,h);
        }
        
        rect.setWidth(Math.abs(e.getX()-rect.getX()));
                rect.setHeight(Math.abs(e.getY()-rect.getY()));
                
                if(rect.getX()>e.getX()){
                    rect.setX(e.getX());
                }
                
                if(rect.getY()>e.getY()){
                    rect.setY(e.getY());
                }
                
                rectTool.strokeRect(rect.getX(),rect.getY(),rect.getWidth(),rect.getHeight());

        });

    }

    private void circleSelected(ActionEvent event) {
      
        circleSelected= true;
        brushSelected= false;
        eraserSelected= false;
        paintBucketSelected= false; 
        lineSelected = false;
        rectSelected= false;
  
     circleTool = canvas.getGraphicsContext2D();
     canvas.setOnMousePressed(e -> {
        
        rect.setX(e.getX());
        rect.setY(e.getY());
        circleTool.setStroke(colorPicker.getValue());
     
        });
     canvas.setOnMouseReleased(e -> {
         
         double size = Double.parseDouble(currentStroke.getText());
         if (circleSelected && !currentStroke.getText().isEmpty()){
            
            circleTool.setLineWidth(size);
         }
          rect.setWidth(Math.abs(e.getX()-rect.getX()));
                rect.setHeight(Math.abs(e.getY()-rect.getY()));
                
                if(rect.getX()>e.getX()){
                    rect.setX(e.getX());
                }
                
                if(rect.getY()>e.getY()){
                    rect.setY(e.getY());
                }
                
                circleTool.strokeOval(rect.getX(),rect.getY(),rect.getWidth(),rect.getHeight());
         
          });
     
             }

    private void brushSize(ActionEvent event) {
        
        double custBrush = Double.parseDouble(bSize.getText());
        currentStroke.setText(bSize.getText());
    }

    
    private void textSelected(ActionEvent event) {
        boolean brushSelected = false;
    boolean eraserSelected = false;
    boolean paintBucketSelected= false;
    boolean lineSelected= false;
    boolean rectSelected= false;
    boolean circleSelected= false;
    boolean textSelected= true;
        
    textTool = canvas.getGraphicsContext2D(); 
    
    }

}
