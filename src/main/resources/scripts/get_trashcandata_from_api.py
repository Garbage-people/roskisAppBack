import urllib.request
import json

def get_data() -> list:
    coords = []
    req = urllib.request.urlopen("https://kartta.hel.fi/ws/geoserver/avoindata/wfs?SERVICE=WFS&VERSION=2.0.0&REQUEST=GetFeature&TYPENAME=hel:YLRE_Katuosat_piste&CQL_FILTER=(alakohde_tyyppi_id%20IN%20(383,384))&SRSNAME=urn:ogc:def:crs:EPSG:4326&OUTPUTFORMAT=json")
    data = json.loads(req.read())["features"]
    for i in range(len(data)):
        coords.append({"lat": data[i]["geometry"]["coordinates"][1], "lon": data[i]["geometry"]["coordinates"][0]})
    return coords

def write_data(data: list):
    output = json.dumps(data, indent=4)
    with open("coordinates.json", "w") as file:
        file.write(output)


# Run command in cli: python get_trashcandata_from_api.py
if __name__ == "__main__":
    write_data(get_data())