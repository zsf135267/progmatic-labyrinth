package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.CellException;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pappgergely
 */
public class LabyrinthImpl implements Labyrinth {
    private int width;
    private int height;
    private CellType[][] labyrinth;

    public LabyrinthImpl() {
        
    }

    @Override
    public void loadLabyrinthFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            width = Integer.parseInt(sc.nextLine());
            height = Integer.parseInt(sc.nextLine());
            
            setSize(width, height);

            for (int hh = 0; hh < height; hh++) {
                String line = sc.nextLine();
                for (int ww = 0; ww < width; ww++) {
                    switch (line.charAt(ww)) {
                        case 'W':
                            setCellType(new Coordinate(ww, hh), CellType.WALL);
                            break;
                        case 'E':
                            setCellType(new Coordinate(ww, hh), CellType.END);
                            break;
                        case 'S':
                            setCellType(new Coordinate(ww, hh), CellType.START);
                            break;
                    }
                }
            }
        } catch (FileNotFoundException | NumberFormatException ex) {
            System.out.println(ex.toString());
        } catch (CellException e){
            System.out.println(e);
        }
    }

    @Override
    public int getWidth() {
        return width > 0 ? width : -1;
    }

    @Override
    public int getHeight() {
        return height > 0 ? height : -1;
    }
    
    @Override
    public CellType getCellType(Coordinate c) throws CellException {
        if(c.getRow() >= height|| c.getRow() < 0 || c.getCol() >= width || c.getCol() < 0){
            throw new CellException(c, "This coordinate is not a point of the labyrinth.");
        }
        return labyrinth[c.getCol()][c.getRow()];
    }

    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void setCellType(Coordinate c, CellType type) throws CellException {
        if(c.getRow() >= height || c.getRow() < 0 || c.getCol() >= width || c.getCol() < 0){
            throw new CellException(c, "This coordinate is not a point of the labyrinth.");
        }
        //labyrinth[c.getCol()][c.getRow()] = type;
    }

    @Override
    public Coordinate getPlayerPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasPlayerFinished() {
        Coordinate c = getPlayerPosition();
        if(labyrinth[c.getCol()][c.getRow()].equals(CellType.END)){
            return true;
        }
        return false;
    }

    @Override
    public List<Direction> possibleMoves() {
        List<Direction> possibleMoves = new ArrayList<>();
        
        
        
        return possibleMoves;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void movePlayer(Direction direction) throws InvalidMoveException {
        
    }

}
