package com.nesstar.demo;

import com.nesstar.api.*;
import java.io.IOException;

public final class NesstarStudyLister {
   private NesstarDB nesstarDB;
   private Server server;

   public NesstarStudyLister(String serverURL, int serverPort) throws IOException {
      nesstarDB = NesstarDBFactory.getInstance();
      server = nesstarDB.getServer(serverURL, serverPort);
   }

   public String getListText() throws NotAuthorizedException, IOException {
      NesstarList <Study> allStudies = server.getBank(Study.class).getAll();
      StringBuilder studyLabelList = new StringBuilder();
      for (Study study : allStudies) {
         studyLabelList.append(study.getLabel());
         studyLabelList.append(System.getProperty("line.separator"));
      }
      return studyLabelList.toString();
   }

   public static void main(String[] args) {
      NesstarStudyLister nesstarDemoServerStudyLister;
      String serverURL = "nesstar-demo.nsd.uib.no";
      int serverPort = 80;

      try {
         nesstarDemoServerStudyLister = new NesstarStudyLister(serverURL, serverPort);
         String studyListText = nesstarDemoServerStudyLister.getListText();
         System.out.println(studyListText);
      } catch (Exception ioe) {
         System.err.println("Error: " + ioe);
      }
   }
}
