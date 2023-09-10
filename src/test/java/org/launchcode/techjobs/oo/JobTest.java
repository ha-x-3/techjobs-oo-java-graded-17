package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", job.getName().toString());
        assertEquals("ACME", job.getEmployer().toString());
        assertEquals("Desert", job.getLocation().toString());
        assertEquals("Quality control", job.getPositionType().toString());
        assertEquals("Persistence", job.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals(System.lineSeparator() +
                        "ID: " + job.getId() +
                        "\nName: " + job.getName() +
                        "\nEmployer: " + job.getEmployer() +
                        "\nLocation: " + job.getLocation() +
                        "\nPosition Type: " + job.getPositionType() +
                        "\nCore Competency: " + job.getCoreCompetency() +
                        System.lineSeparator(),
                                        job.toString());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertEquals(System.lineSeparator() +
                "ID: " + job.getId() +
                "\nName: " + job.getName() +
                "\nEmployer: " + job.getEmployer() +
                "\nLocation: " + job.getLocation() +
                "\nPosition Type: " + job.getPositionType() +
                "\nCore Competency: " + job.getCoreCompetency() +
                System.lineSeparator(),
                                job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job();
        assertEquals("OOPS! This job does not seem to exist.", job1.toString());
        Job job2 = new Job("Product tester",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));
        assertEquals(System.lineSeparator() +
                "ID: " + job2.getId() +
                "\nName: " + job2.getName() +
                "\nEmployer: " + "Data not available" +
                "\nLocation: " + "Data not available" +
                "\nPosition Type: " + "Data not available" +
                "\nCore Competency: " + "Data not available" +
                System.lineSeparator(), job2.toString());
    }
}
