package com.nesstar.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;

public class NesstarStudyListerTest {
   private NesstarStudyLister nsl = null;
   private String studyLabels = "";

   @Before
   public void setUp() {
      try {
         nsl = new NesstarStudyLister(new URI("http://nesstar-demo.nsd.uib.no"));
         studyLabels = nsl.getListText();
      } catch (Exception e) {

      }
   }

   @Test
   public void listcontainsBritishGeneralElectionStudy() {
      assertThat("Contains British Crime Survey", studyLabels, containsString("British Crime Survey"));
   }

   @Test
   public void listcontainsDemonstrationDataset() {
      assertThat("Contains Demonstration dataset", studyLabels, containsString("Demonstration dataset"));
   }

   @Test
   public void listcontainsLifeExpectancyAtBirth() {
      assertThat("Contains Environment, 2000, ISPP", studyLabels, containsString("Environment, 2000, Norwegian part of ISSP"));
   }
}
