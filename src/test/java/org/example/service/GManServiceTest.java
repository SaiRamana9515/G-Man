package org.example.service;

import org.example.exceptions.InvalidInputException;
import org.example.model.GMan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GManServiceTest {

    private GManService gManService;

    @BeforeEach
    public void setup(){
        gManService = new GManService();
    }

    @Test
    public void test_createGManWithSource_ok() throws Exception {
        int x_coordinate = 1;
        int y_coordinate = 2;
        String direction = "E";

        GMan gMan = gManService.createGManWithSource(x_coordinate, y_coordinate, direction);

        Assertions.assertEquals(x_coordinate, gMan.getSourceCoordinate().getX_coordinate());
        Assertions.assertEquals(y_coordinate, gMan.getSourceCoordinate().getY_coordinate());
        Assertions.assertEquals(direction, gMan.getSourceDirection().toString());
    }

    @Test
    public void test_createGManWithSource_invalid_source_x_coordinate_LT_0(){
        int x_coordinate = -1;
        int y_coordinate = 2;
        String direction = "E";

        Exception ex = Assertions.assertThrows(InvalidInputException.class, () -> gManService.createGManWithSource(x_coordinate, y_coordinate, direction));
        Assertions.assertEquals("Invalid x-coordinate is given", ex.getMessage());
    }
    @Test
    public void test_createGManWithSource_invalid_source_x_coordinate_GT_6(){
        int x_coordinate = 7;
        int y_coordinate = 2;
        String direction = "E";

        Exception ex = Assertions.assertThrows(InvalidInputException.class, () -> gManService.createGManWithSource(x_coordinate, y_coordinate, direction));
        Assertions.assertEquals("Invalid x-coordinate is given", ex.getMessage());
    }

    @Test
    public void test_createGManWithSource_invalid_source_y_coordinate_LT_0(){
        int x_coordinate = 1;
        int y_coordinate = -2;
        String direction = "E";

        Exception ex = Assertions.assertThrows(InvalidInputException.class, () -> gManService.createGManWithSource(x_coordinate, y_coordinate, direction));

        Assertions.assertEquals("Invalid y-coordinate is given", ex.getMessage());
    }
    @Test
    public void test_createGManWithSource_invalid_source_y_coordinate_GT_6(){
        int x_coordinate = 1;
        int y_coordinate = 7;
        String direction = "E";

        Exception ex = Assertions.assertThrows(InvalidInputException.class, () -> gManService.createGManWithSource(x_coordinate, y_coordinate, direction));

        Assertions.assertEquals("Invalid y-coordinate is given", ex.getMessage());
    }

    @Test
    public void test_createGManWithSource_invalid_source_direction(){
        int x_coordinate = 1;
        int y_coordinate = 6;
        String direction = "F";

        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> gManService.createGManWithSource(x_coordinate, y_coordinate, direction));
        Assertions.assertTrue(ex.getMessage().contains("No enum constant"));
    }

    @Test
    public void test_setDestinationInGame_ok() throws Exception {
        int source_x_coordinate = 1;
        int source_y_coordinate = 2;
        String source_direction = "E";
        int dest_x_coordinate = 5;
        int dest_y_coordinate = 6;

        GMan gMan = gManService.createGManWithSource(source_x_coordinate, source_y_coordinate, source_direction);
        gManService.setDestinationInGame(dest_x_coordinate, dest_y_coordinate);

        Assertions.assertEquals(dest_x_coordinate, gMan.getDestinationCoordinate().getX_coordinate());
        Assertions.assertEquals(dest_y_coordinate, gMan.getDestinationCoordinate().getY_coordinate());
    }

    @Test
    public void test_setDestinationInGame_invalid_destination_x_coordinate_LT_0() throws Exception {
        int source_x_coordinate = 1;
        int source_y_coordinate = 2;
        String source_direction = "E";
        int dest_x_coordinate = -1;
        int dest_y_coordinate = 6;

        gManService.createGManWithSource(source_x_coordinate, source_y_coordinate, source_direction);
        Exception ex = Assertions.assertThrows(InvalidInputException.class, () -> gManService.setDestinationInGame(dest_x_coordinate, dest_y_coordinate));

        Assertions.assertEquals("Invalid x-coordinate is given", ex.getMessage());
    }
    @Test
    public void test_setDestinationInGame_invalid_destination_x_coordinate_GT_6() throws Exception {
        int source_x_coordinate = 1;
        int source_y_coordinate = 2;
        String source_direction = "E";
        int dest_x_coordinate = 7;
        int dest_y_coordinate = 6;

        gManService.createGManWithSource(source_x_coordinate, source_y_coordinate, source_direction);
        Exception ex = Assertions.assertThrows(InvalidInputException.class, () -> gManService.setDestinationInGame(dest_x_coordinate, dest_y_coordinate));

        Assertions.assertEquals("Invalid x-coordinate is given", ex.getMessage());
    }

    @Test
    public void test_setDestinationInGame_invalid_destination_y_coordinate_LT_0() throws Exception {
        int source_x_coordinate = 1;
        int source_y_coordinate = 2;
        String source_direction = "E";
        int dest_x_coordinate = 1;
        int dest_y_coordinate = -2;

        gManService.createGManWithSource(source_x_coordinate, source_y_coordinate, source_direction);
        Exception ex = Assertions.assertThrows(InvalidInputException.class, () -> gManService.setDestinationInGame(dest_x_coordinate, dest_y_coordinate));

        Assertions.assertEquals("Invalid y-coordinate is given", ex.getMessage());
    }
    @Test
    public void test_setDestinationInGame_invalid_destination_y_coordinate_GT_6() throws Exception {
        int source_x_coordinate = 1;
        int source_y_coordinate = 2;
        String source_direction = "E";
        int dest_x_coordinate = 1;
        int dest_y_coordinate = 7;

        gManService.createGManWithSource(source_x_coordinate, source_y_coordinate, source_direction);
        Exception ex = Assertions.assertThrows(InvalidInputException.class, () -> gManService.setDestinationInGame(dest_x_coordinate, dest_y_coordinate));

        Assertions.assertEquals("Invalid y-coordinate is given", ex.getMessage());
    }

    @Test
    public void test_getRemainingPower_ok() throws Exception {
        int source_x_coordinate = 3;
        int source_y_coordinate = 6;
        String source_direction = "N";
        int dest_x_coordinate = 1;
        int dest_y_coordinate = 0;
        gManService.createGManWithSource(source_x_coordinate, source_y_coordinate, source_direction);
        gManService.setDestinationInGame(dest_x_coordinate, dest_y_coordinate);
        int expected_remaining_power = 110;
        int actual_remaining_power = gManService.getRemainingPower();

        Assertions.assertEquals(expected_remaining_power, actual_remaining_power);
    }
}
