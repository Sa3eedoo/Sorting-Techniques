package sample;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Main extends Application {
    SelectionSort selectionSortObject=new SelectionSort();
    BubbleSort bubbleSortObject=new BubbleSort();
    MergeSort mergeSortObject =new MergeSort();
    QuickSort quickSortObject = new QuickSort();
    InsertionSort insertionSortObject = new InsertionSort();
    HeapSort heapSortObject = new HeapSort();

    CopyArray copy = new CopyArray();


    @Override
    public void start(Stage window) throws Exception {

        //.........................Scene(1)..........................//
        Label chooseSizeOfArrayLable=new Label("choose Size Of Array");

        Button button10=new Button("10");
        Button button100=new Button("100");
        Button button1000=new Button("1000");
        Button button10000=new Button("10000");
        Button buttonCusomized=new Button("Customize size");

        VBox layoutVbox1=new VBox();
        layoutVbox1.setAlignment(Pos.CENTER);
        layoutVbox1.setSpacing(20);
        layoutVbox1.getChildren().addAll(chooseSizeOfArrayLable,button10,button100,button1000,button10000,buttonCusomized);

        Scene scene1 =new Scene(layoutVbox1,600,600);
        window.setScene(scene1);
        scene1.getStylesheets().addAll("library.css");
        window.setTitle("Home Page");
        window.show();
        //.........................(animation)...................................//
        parallelTransition(button10,duration1);
        parallelTransition(button100,duration2);
        parallelTransition(button1000,duration3);
        parallelTransition(button10000,duration4);
        parallelTransition(buttonCusomized,duration5);

        //........................Scene(2)...........................//
        Label customizeSizeLable =new Label("Write your preferred Size :");
        TextField customizeSizeTextfield =new TextField(" ");
        customizeSizeTextfield.setPromptText("Enter array size here!!");
        Button doneButton =new Button("Done");
        Button returnButton=new Button("Return");

        HBox hBox =new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(customizeSizeLable,customizeSizeTextfield);

        VBox layoutVbox2 =new VBox();
        layoutVbox2.setAlignment(Pos.CENTER);
        layoutVbox2.setSpacing(20);
        layoutVbox2.getChildren().addAll(hBox,doneButton,returnButton);

        Scene scene2 =new Scene(layoutVbox2,650,600);
        scene2.getStylesheets().addAll("library.css");

        //........................Error window...........................//
        Label errorLable =new Label("                     Error!!\n please enter a positive integer");
        Button okButton =new Button("OK");
        VBox layoutVbox3 =new VBox();
        layoutVbox3.setAlignment(Pos.CENTER);
        layoutVbox3.setSpacing(20);
        layoutVbox3.getChildren().addAll(errorLable,okButton);
        Scene scene3=new Scene(layoutVbox3,500,200);
        scene3.getStylesheets().addAll("library2.css");
        Stage errorWindow =new Stage();
        errorWindow.setScene(scene3);
        errorWindow.setTitle("error");

        //...................................................//
        button10.setOnAction(e->{
            processingInput(10);
        });


        button100.setOnAction(e->{
            processingInput(100);
        });


        button1000.setOnAction(e->{
           processingInput(1000);
        });


        button10000.setOnAction(e->{
            processingInput(10000);
        });

        buttonCusomized.setOnAction(e->{
            window.setScene(scene2);
            window.setTitle("Customized Array");
            customizeSizeTextfield.setText("");
        });

        doneButton.setOnAction(e->{
            if(isNumeric(customizeSizeTextfield.getText())){
                processingInput(Integer.parseInt(customizeSizeTextfield.getText()));
            }
            else {
               errorWindow.showAndWait();
            }

        });
        returnButton.setOnAction(e->{
            window.setScene(scene1);
            window.setTitle("Home Page");
        });
        okButton.setOnAction(e->{
            errorWindow.close();
            customizeSizeTextfield.setText("");
        });

    }

    //..............................(animation)....................................//
    Duration duration1=Duration.millis(250);
    Duration duration2=Duration.millis(500);
    Duration duration3=Duration.millis(750);
    Duration duration4=Duration.millis(1000);
    Duration duration5=Duration.millis(1250);


    public void parallelTransition(Button button, Duration duration){


        TranslateTransition translateTransition =new TranslateTransition();
        translateTransition.setNode(button);
        translateTransition.setDuration(duration);
        translateTransition.setFromX(800);
        translateTransition.setToX(button.getTranslateX());
        translateTransition.setCycleCount(1);



        FadeTransition fadeTransition =new FadeTransition();
        fadeTransition.setNode(button);
        fadeTransition.setDuration(duration);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);

        ParallelTransition parallelTransition =new ParallelTransition(translateTransition,fadeTransition);
        parallelTransition.play();
    }

    //..................................................................//
    public static void main(String[] args) {
        launch(args);
    }

    private static void printArray(int[] array) {

        for(int k=0;k<array.length;k++) {
            System.out.print(array[k] + "   ");
        }
        System.out.println("");
    }

    public void processingInput (int arraySize){
        int [] RandomNumbersArray =new int[arraySize];
        for (int i=0;i<arraySize;i++){
            Random random=new Random();
            int randomNumber =random.nextInt(101);
            RandomNumbersArray[i]=randomNumber;
        }
        printArray(RandomNumbersArray);
        System.out.println("...........................................................................");

        long startTime;
        long endTime;

        int [] selectionUnsortedArray =new int[arraySize];
        selectionUnsortedArray=copy.copy(RandomNumbersArray);

        int [] bubbleUnsortedArray =new int[arraySize];
        bubbleUnsortedArray=copy.copy(RandomNumbersArray);

        int [] mergeUnsortedArray =new int[arraySize];
        mergeUnsortedArray=copy.copy(RandomNumbersArray);

        int [] insertionUnsortedArray =new int[arraySize];
        insertionUnsortedArray=copy.copy(RandomNumbersArray);

        int [] heapUnsortedArray =new int[arraySize];
        heapUnsortedArray=copy.copy(RandomNumbersArray);

        int [] quickUnsortedArray =new int[arraySize];
        quickUnsortedArray=copy.copy(RandomNumbersArray);

        //....................................................................................//

        System.out.println("Sorting of random array of " +RandomNumbersArray.length+ " elements");
        System.out.println("...........................................................................");

        System.out.println("Array before Sorting >>>");
        printArray(selectionUnsortedArray);
        startTime = System.currentTimeMillis();
        selectionSortObject.sort(selectionUnsortedArray,selectionUnsortedArray.length);
        endTime =System.currentTimeMillis();
        System.out.println("Selection Sort >>>");
        printArray(selectionUnsortedArray);
        System.out.println("\nTime Taken By Selection Sort is "+(endTime-startTime)+" milliseconds");
        System.out.println("...........................................................................");



        System.out.println("Array before Sorting >>>");
        printArray(bubbleUnsortedArray);
        startTime = System.currentTimeMillis();
        bubbleSortObject.sort(bubbleUnsortedArray,bubbleUnsortedArray.length);
        endTime =System.currentTimeMillis();
        System.out.println("Bubble Sort >>>");
        printArray(bubbleUnsortedArray);
        System.out.println("\nTime Taken By Bubble Sort is "+(endTime-startTime)+" milliseconds");
        System.out.println("...........................................................................");


        System.out.println("Array before Sorting >>>");
        printArray(quickUnsortedArray);
        startTime = System.currentTimeMillis();
        quickSortObject.sort(quickUnsortedArray);
        endTime =System.currentTimeMillis();
        System.out.println("Quick Sort >>>");
        printArray(quickUnsortedArray);
        System.out.println("\nTime Taken By Quick Sort is "+(endTime-startTime)+" milliseconds");
        System.out.println("...........................................................................");


        System.out.println("Array before Sorting >>>");
        printArray(insertionUnsortedArray);
        startTime = System.currentTimeMillis();
        insertionSortObject.sort(insertionUnsortedArray);
        endTime =System.currentTimeMillis();
        System.out.println("Insertion Sort >>>");
        printArray(insertionUnsortedArray);
        System.out.println("\nTime Taken By Insertion Sort is "+(endTime-startTime)+" milliseconds");
        System.out.println("...........................................................................");


        System.out.println("Array before Sorting >>>");
        printArray(heapUnsortedArray);
        startTime = System.currentTimeMillis();
        heapSortObject.sort(heapUnsortedArray);
        endTime =System.currentTimeMillis();
        System.out.println("Heap Sort >>>");
        printArray(heapUnsortedArray);
        System.out.println("\nTime Taken By Heap Sort is "+(endTime-startTime)+" milliseconds");
        System.out.println("...........................................................................");


        System.out.println("Array before Sorting >>>");
        printArray(mergeUnsortedArray);
        startTime = System.currentTimeMillis();
        mergeUnsortedArray=mergeSortObject.sort(mergeUnsortedArray);
        endTime =System.currentTimeMillis();
        System.out.println("Merge Sort >>>");
        printArray(mergeUnsortedArray);
        System.out.println("\nTime Taken By Merge Sort is "+(endTime-startTime)+" milliseconds");
        System.out.println("...........................................................................");

    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        if (strNum.contains(".")) {
            return false;
        }
        try {
            Integer d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        if (Integer.parseInt(strNum) <= 0) {
            return false;
        }
        return true;
    }

}



