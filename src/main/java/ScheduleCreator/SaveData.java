package ScheduleCreator;
//creates a text file and writes the results from the original web search

import java.io.*;


public class SaveData  {
                                      
	 static FileWriter WriteFile(String Name, int Sem, int Dep){
        
                    // Create new file, write all results into the file
                    try{
                    String content = ScheduleCreator.GetData.GetDataMethod(Sem, Dep);
                    String path = Name;
                    File file = new File(path);
                         
                    // If file doesn't exists, then create it
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                        FileWriter FileW = new FileWriter(file.getAbsoluteFile());
                        BufferedWriter BufferW = new BufferedWriter(FileW);

                        // Write in file
                        BufferW.write(content);

                        // Close connection
                        BufferW.close();
                        
                        return FileW;

                    }
                    //Exception filler 
                    catch(Exception X){
                        System.out.println(X);
                    }


                        return null;

        }

}