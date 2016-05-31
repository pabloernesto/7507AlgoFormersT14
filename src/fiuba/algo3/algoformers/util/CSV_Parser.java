package fiuba.algo3.algoformers.util;

public class CSV_Parser
{
    public static List<String[]> csvToArraysOfStrings(String nombreDeArchivo)
        throws IOException
    {
    	FileReader reader = null;
		try {
			reader = new FileReader(nombreDeArchivo);
		} catch (FileNotFoundException e) {
			throw new IOException();
		}
        
        BufferedReader bReader = new BufferedReader(reader);
        List<String[]> outp = new ArrayList<String[]>();
        
        String linea;
        while ((linea = reader.readLine()) != null)
        {
        	String[] campos = linea.split(",");
        	outp.add(campos);
        }
        
        return outp;   
    }
/*
    public static List<String[]> csvToArraysOfData(String nombreDeArchivo)
        throws IOException
    {
        List<String[]> arrays;
        try {
            arrays = CSV_Parser.csvToArraysOfStrings(nombreDeArchivo);
        } catch (IOException e) {
            throw e;
        }
        
        for (String[] a : arrays)
        {
            for (String s : a)
            {
                Integer.parseInt(s);
            }
        }
    }
*/
}
