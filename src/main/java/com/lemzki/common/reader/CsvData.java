package com.lemzki.common.reader;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Holder for List of records parse from file
 * and the header. To be used for reflectio nwhen
 * the headers match the name of the properties
 */
@Getter
@ToString
@AllArgsConstructor
public final class CsvData {
    private String[] headers;
    private List<CSVRecord> records = new ArrayList<>();


}
