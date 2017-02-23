
package lab2;

import java.io.*;

public class Matrix 
{
    
    public Matrix(int col, int row)
    {
       try
        {
             if (col == 0) 
             {
                 col = 1;
             }
             if (row == 0) 
             {
                 row = 1;
             }
             matrix = new int[col][row];
             System.out.println("Matris size is " + col + " x " + row + " accepted");
        }
       catch (OutOfMemoryError e)
        {
           System.out.println("Requested matrix size: " + col + " x " + row); 
           System.out.println("Out of memory exception!");
           System.out.println(e.getClass());
           System.out.println(e.getClass().getSuperclass());
           System.out.println(e.getClass().getSuperclass().getSuperclass());
           System.out.println();
        }
    }
    
    public Matrix()
    {
        this(1, 1);
    }
    
    public void output()
    {
        for (int[] row : matrix)
        {
            for (int col : row)
            {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    
    public Matrix add(Matrix otherMatrix) throws SizeMatrixError
    {
        
        if ((matrix.length == otherMatrix.matrix.length) && 
                (matrix[0].length == otherMatrix.matrix[0].length))
        {
            int col = matrix.length;
            int row = matrix[0].length;
            Matrix outputMatrix = new Matrix(col, row);
            for (int i = 0; i < col; ++i)
            {
                for (int j = 0; j < row; ++j)
                {
                    outputMatrix.matrix[i][j] = matrix[i][j] + otherMatrix.matrix[i][j];                    
                }
            }
            return outputMatrix;
        }
        else
        {
           throw new SizeMatrixError("The matrices are not equal!");
        }
    }
    
    public void read(int col, int row, String Filename)
    {
        final int SIZE_BUFFRE = 11;
        int n = 0, m = 0;
        int i = -1, j = 0;
        char[] buffer = new char[1];
        
        try
        {
            buffer = new char[11];
        }
        catch (OutOfMemoryError e)
        {
            System.out.println("Out of memory exception (buffer)!");
            System.out.println(e.getClass());
            System.out.println(e.getClass().getSuperclass());
            System.out.println(e.getClass().getSuperclass().getSuperclass());
            System.out.println();
        }
        
        Matrix tmp = new Matrix(col, row);
        
        char str = '0';
        try (FileInputStream myInput = new FileInputStream(Filename)) 
        {
            
                i = myInput.read();
                while (i != -1)
                {
                    str = (char)i;                                    
                    
                    if ((str >= '0' && str <= '9') || str == '+' || str == '-')
                    {
                      for (char el : buffer) 
                      {
                          el = ' ';
                      }
                    j = 0;
                        while ((str >= '0' && str <= '9') || str == '+' || str == '-')
                      {
                          buffer[j] = str;
                          ++j;
                          i = myInput.read();
                          str = (char)i;
                          if (j == SIZE_BUFFRE || i == -1) {break;}
                      }
                      
                      try 
                      {
                          String s = new String(buffer, 0, j);
                          tmp.matrix[m][n] = Integer.parseInt(s);
                          ++m;
                          if (m == tmp.matrix.length) 
                          {
                              m = 0;
                              ++n;
                          }
                          if (n == tmp.matrix[0].length)
                          {
                              matrix = tmp.matrix;
                              return;
                          }
                          
                      } 
                      catch(NumberFormatException s)
                      {
                          System.out.println("In string \"" + s.getLocalizedMessage() + "\" not a number!");
                          System.exit(1);
                      }
                    }
                    i = myInput.read();
                }
            
            System.out.println("The result: " + str);
        }
        
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
            System.out.println(e.getClass());
            System.out.println(e.getClass().getSuperclass());
            System.out.println(e.getClass().getSuperclass().getSuperclass());
            System.out.println();
        }
        
        catch (IOException e)
        {
            System.out.println("IO error!");
            System.out.println(e.getClass());
            System.out.println(e.getClass().getSuperclass());
            System.out.println(e.getClass().getSuperclass().getSuperclass());
            System.out.println();
        }

	catch (NumberFormatException e) 
	{
            System.out.println("Wrong number!");
            System.out.println(e.getClass());
            System.out.println(e.getClass().getSuperclass());
            System.out.println(e.getClass().getSuperclass().getSuperclass());
            System.out.println();
	}
        
	catch (ArrayIndexOutOfBoundsException e) 
	{
            System.out.println("Wrong matrix size!");
            System.out.println(e.getClass());
            System.out.println(e.getClass().getSuperclass());
            System.out.println(e.getClass().getSuperclass().getSuperclass());
            System.out.println();
	}

    }
    
    public void write(String Filename)
    {        
        try (FileOutputStream myOutput = new FileOutputStream(Filename))
        {
            for (int[] col : matrix)
            {
                for (int row : col) 
                {
                    String s = Integer.toString(row);
                    
                    int sizeBuffer = s.length();
                    for (int i = 0; i < sizeBuffer; ++i)
                    {
                        myOutput.write(s.charAt(i));                       
                    }
                    
                    myOutput.write('\n');
                }
            }
            myOutput.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
            System.out.println(e.getClass());
            System.out.println(e.getClass().getSuperclass());
            System.out.println(e.getClass().getSuperclass().getSuperclass());
            System.out.println();
        }
        
        catch (IOException e)
        {
            System.out.println("IO error!");
            System.out.println(e.getClass());
            System.out.println(e.getClass().getSuperclass());
            System.out.println(e.getClass().getSuperclass().getSuperclass());
            System.out.println();
        }
    }

    public boolean equal(Matrix otherMatrix)
    {
        int col = otherMatrix.matrix.length;
        int row = otherMatrix.matrix[0].length;
        if ((matrix.length == col) && (matrix[0].length == row))
        {
            for (int i = 0; i < col; ++i)
            {
                for (int j = 0; j < row; ++j)
                {
                    if (matrix[i][j] != otherMatrix.matrix[i][j]) 
                    {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    protected int matrix[][];
    protected int col, row;
}
