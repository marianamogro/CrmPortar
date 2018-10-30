package com.nuevatel.crm.sensor.csv;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVReader;

public class Csv implements ICsv {
	// private static final String SAMPLE_CSV_FILE_PATH = "./ftp/npc_daily_portings_and_returns_2018-10-19.csv";

	@Override
	public Integer countCsvRows(String fileName) throws Exception {
		Integer result =0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(fileName));
                CSVReader csvReader = new CSVReader(reader);
            ) {
                // Reading Records One by One in a String array
                String[] nextRecord;
                while ((nextRecord = csvReader.readNext()) != null) {
                	if (nextRecord.length >3) {
                		 System.out.println("Name : " +  nextRecord[3]);
                		 result++;
                	}
                   

                    System.out.println("==========================");
                }
            }
        return result;
        }
	}


