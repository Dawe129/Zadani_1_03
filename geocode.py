import csv
import re

CSV_FILE = 'aktivace_dm_jaro_2024.csv'
CSV_GPS_FIELD = 'souradnice'

def parse_dms(dms):
    parts = re.split('[°\'"]+', dms)
    dd = float(parts[0]) + float(parts[1]) / 60 + float(parts[2]) / (60 * 60)
    if parts[3] == 'W' or parts[3] == 'S':
        dd *= -1
    return dd

def dms_to_dd(coordinate):
    if coordinate == "":
        return coordinate
    else:
        gps_array = coordinate.split(' ')
        lat = parse_dms(gps_array[0])
        long = parse_dms(gps_array[1])
        return f"{lat},{long}"

if __name__ == "__main__":
    with open(CSV_FILE, newline='') as csv_input:
        for row in csv.DictReader(csv_input, delimiter=';'):
            row['dd'] = dms_to_dd(row[CSV_GPS_FIELD])
            for values in row.values():
                print(values, end=';')
            print("")
