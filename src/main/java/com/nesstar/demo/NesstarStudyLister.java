package com.nesstar.demo;

import java.io.IOException;
import java.net.URI;

import com.nesstar.api.NesstarDB;
import com.nesstar.api.NesstarDBFactory;
import com.nesstar.api.NesstarList;
import com.nesstar.api.NotAuthorizedException;
import com.nesstar.api.Server;
import com.nesstar.api.Study;

public final class NesstarStudyLister {
   private final NesstarDB nesstarDB;
   private final Server server;

   public NesstarStudyLister(URI serverURI) throws IOException {
      nesstarDB = NesstarDBFactory.getInstance();
      server = nesstarDB.getServer(serverURI);
   }

   public String getListText() throws NotAuthorizedException, IOException {
      NesstarList<Study> allStudies = server.getBank(Study.class).getAll();
      StringBuilder studyLabelList = new StringBuilder();
      for (Study study : allStudies) {
         studyLabelList.append(study.getLabel());
         studyLabelList.append(System.getProperty("line.separator"));
      }
      return studyLabelList.toString();
   }

   public static void main(String[] args) {
      NesstarStudyLister nesstarDemoServerStudyLister;

      try {
         nesstarDemoServerStudyLister = new NesstarStudyLister(new URI("http://nesstar-demo.nsd.uib.no"));
         String studyListText = nesstarDemoServerStudyLister.getListText();
         System.out.println(studyListText);
      } catch (Exception ioe) {
         System.err.println("Error: " + ioe);
      }
   }
}
