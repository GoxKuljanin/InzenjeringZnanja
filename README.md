# InzenjeringZnanja
Aplikacija koja lekarima omogucava podrsku za evidentiranje pregleda iz oblasti Neurologije.

Aplikacija omogucava predikciju dopunskih ispitivanja na osnovu anamneze i fizikalnog pregleda, predikciju dijagnoze na osnovu fizikalnog pregleda i dopunskih ispitivanja i predikciju lekova na osnovu dijagnoza.

Predikcija koju aplikacija koristi je realizovana na dva nacina: Case Based Reasoning i Rule Based Reasoning. Baza znanja je popunjena inicijalnim podacima preuzetih uglavnom sa "http://www.symcat.com/symptoms/neurological-symptoms", i testni primeri se nalaze u sql skripti, za CBR, i u folderu ./data/ za RBR.

Backend:

Realizovan preko STS frameworka u Java programskom jeziku.
Neposredno prije pokretanja, neophodno je iz razvojnog okruzenja ukljuciti sve biblioteke koje se nalaze u folderu ./lib/ -> Desni klik na biblioteku, a potom na Add To Build Path.
Nakon toga pokrenuti program, koji ce nakon uspesnog pokretanja slusati na portu 8089.
Front:

Realizovan kao Angular aplikacija.
Neophodno je instalirati sve biblioteke naredbom : "npm install".
Nakon toga, pokrenuti aplikaciju naredbom : "ng serve".
Aplikacija je uspesno pokrenuta i slusa na portu 4200.
Nakon toga, aplikacija je spremna za rad.

-Link video zapisa na google drive-u (u slucaju nemoucnosti otvaranja video zapisa iz foldera na gitu): https://drive.google.com/file/d/1n424_Jn0620wty-ZlgFsiHxhcqLbPUW_/view?usp=sharing
