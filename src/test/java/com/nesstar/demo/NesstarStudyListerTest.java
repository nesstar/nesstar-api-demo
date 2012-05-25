package com.nesstar.demo;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NesstarStudyListerTest {
   private NesstarStudyLister nsl = null;
   private String studyLabels="";
  
   @Before
   public void setUp() {
      try {
         nsl = new NesstarStudyLister("nesstar-demo.nsd.uib.no", 80);
         studyLabels=nsl.getListText();
      } catch (Exception e) {
      
      }
   }

   @Test
   public void listcontainsBritishGeneralElectionStudy() {
      assertThat("Contains British General Election Study", studyLabels, containsString("British General Election Study"));
   }
   
   @Test
   public void listcontainsDemonstrationDataset() {
      assertThat("Contains Demonstration dataset", studyLabels, containsString("Demonstration dataset"));
   }
   
   @Test
   public void listcontainsLifeExpectancyAtBirth() {
      assertThat("Contains Life expectancy at birth cube", studyLabels, containsString("Life expectancy at birth"));
   }
}
