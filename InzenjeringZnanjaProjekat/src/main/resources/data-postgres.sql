insert into karton (id) values (1001);
insert into karton (id) values (2001);
insert into karton (id) values (3001);

insert into pacijent (name, lastname, karton_id) values ('Petar', 'Petrovic', 1001);
insert into pacijent (name, lastname, karton_id) values ('Srecko', 'Sreckovic', 2001);
insert into pacijent (name, lastname, karton_id) values ('Marko', 'Markovic', 3001);

insert into dijagnoza (name) values ('Essential tremor');
insert into dijagnoza (name) values ('Parkinson disease');
insert into dijagnoza (name) values ('Restless leg syndrome');
insert into dijagnoza (name) values ('Anxiety');
insert into dijagnoza (name) values ('Epilepsy');--5
insert into dijagnoza (name) values ('Alcohol abuse');
insert into dijagnoza (name) values ('Migraine');
insert into dijagnoza (name) values ('Developmental disability');
insert into dijagnoza (name) values ('Common cold');
insert into dijagnoza (name) values ('Chronic sinusitis');--10
insert into dijagnoza (name) values ('Bruise');
insert into dijagnoza (name) values ('Alzheimer disease');
insert into dijagnoza (name) values ('Delirium');
insert into dijagnoza (name) values ('Depression');
insert into dijagnoza (name) values ('Dementia');

--insert into pregled(dijagnoza_id, karton_id) values (1, 1);
--insert into pregled(dijagnoza_id, karton_id) values (2, 2);
--insert into pregled(dijagnoza_id, karton_id) values (3, 3);
--insert into pregled(dijagnoza_id, karton_id) values (4, 3);

insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values ( 1001, 45, 88, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values ( 1001, 46, 72, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values ( 1001, 47, 58, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values ( 1001, 48, 67, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values ( 2001, 55, 94, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values ( 2001, 56, 102, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values ( 2001, 56, 110, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values ( 2001, 56, 60, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values ( 3001, 57, 57, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values ( 3001, 57, 78, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values ( 3001, 58, 83, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values ( 3001, 60, 80, 'm', 'white');

insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values (1001, 48, 64, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values (1001, 48, 72, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values (2001, 56, 81, 'm', 'white');
insert into pregled( karton_id, brojgodina, tezina, pol, rasa) values (3001, 60, 82, 'm', 'white');

insert into lek (name) values ('Beta blockers');
insert into lek (name) values ('Anti-seizure medications');
insert into lek (name) values ('Tranquilizers');
insert into lek (name) values ('Botox injections');
insert into lek (name) values ('Cadibopa-levodopa');--5
insert into lek (name) values ('Dopamine agonists');
insert into lek (name) values ('Anticholinergics');
insert into lek (name) values ('Amantadine');
insert into lek (name) values ('Opioids');
insert into lek (name) values ('Muscle relaxants and sleep medications');--10
insert into lek (name) values ('Drugs affecting calcium channels');
insert into lek (name) values ('Medications that increase dopamine in the brain');
insert into lek (name) values ('Psychotherapy');
insert into lek (name) values ('Antidepressants');
insert into lek (name) values ('Detox and withrawal');--15
insert into lek (name) values ('Supportive environment and counseling');
insert into lek (name) values ('Educational assistance');
insert into lek (name) values ('Pain relievers');
insert into lek (name) values ('Triptans');
insert into lek (name) values ('Anti-nausea drugs');--20
insert into lek (name) values ('Decongestant nasal sprays');
insert into lek (name) values ('Cough syrups');
insert into lek (name) values ('Aspirin desensitization treatment');
insert into lek (name) values ('Cholinesterase inhibitors');
insert into lek (name) values ('Memantine');--25

--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (1,1);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (1,2);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (1,3);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (1,4);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (2,5);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (2,6);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (2,7);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (2,8);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (3,9);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (3,10);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (3,11);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (3,12);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (4,13);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (4,14);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (6,15);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (6,13);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (6,16);--
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (8,16);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (8,17);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (7,18);--
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (7,19);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (7,9);--
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (9,18);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (9,21);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (9,22);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (10,21);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (10,23);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (12,24);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (12,25);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (13,16);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (14,13);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (14,14);
--insert into dijagnoza_lek (dijagnoza_id,lek_id) values (15,13);

insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (1, 1);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (2, 1);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (3, 1);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (4, 1);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (1, 2);--
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (2, 2);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (3, 2);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (4, 2);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (1, 3);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (2, 3);--
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (3, 3);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (4, 3);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (1, 4);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (2, 4);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (1, 6);--
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (2, 6);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (3, 6);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (2, 8);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (3, 8);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (1, 7);--
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (2, 7);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (3, 7);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (2, 9);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (4, 9);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (3, 9);--
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (1, 10);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (2, 10);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (1, 12);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (2, 12);
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (1, 13);--
insert into pregled_dijagnoze (pregled_id, dijagnoza_id) values (3, 15);

insert into pregled_lekovi (pregled_id, lek_id) values (1, 1);
insert into pregled_lekovi (pregled_id, lek_id) values (2, 2);
insert into pregled_lekovi (pregled_id, lek_id) values (3, 3);
insert into pregled_lekovi (pregled_id, lek_id) values (4, 4);
--insert into pregled_lekovi (pregled_id, lek_id) values (1, 5);--
--insert into pregled_lekovi (pregled_id, lek_id) values (2, 6);
--insert into pregled_lekovi (pregled_id, lek_id) values (3, 7);
--insert into pregled_lekovi (pregled_id, lek_id) values (4, 8);
--insert into pregled_lekovi (pregled_id, lek_id) values (1, 9);
--insert into pregled_lekovi (pregled_id, lek_id) values (2, 10);--
--insert into pregled_lekovi (pregled_id, lek_id) values (3, 11);
--insert into pregled_lekovi (pregled_id, lek_id) values (4, 12);
--insert into pregled_lekovi (pregled_id, lek_id) values (1, 13);
--insert into pregled_lekovi (pregled_id, lek_id) values (2, 14);
--insert into pregled_lekovi (pregled_id, lek_id) values (1, 15);--
--insert into pregled_lekovi (pregled_id, lek_id) values (2, 13);
--insert into pregled_lekovi (pregled_id, lek_id) values (3, 16);
--insert into pregled_lekovi (pregled_id, lek_id) values (2, 16);
--insert into pregled_lekovi (pregled_id, lek_id) values (3, 17);
--insert into pregled_lekovi (pregled_id, lek_id) values (1, 18);--
--insert into pregled_lekovi (pregled_id, lek_id) values (2, 19);
--insert into pregled_lekovi (pregled_id, lek_id) values (3, 9);
--insert into pregled_lekovi (pregled_id, lek_id) values (2, 18);
--insert into pregled_lekovi (pregled_id, lek_id) values (4, 21);
--insert into pregled_lekovi (pregled_id, lek_id) values (3, 22);--
--insert into pregled_lekovi (pregled_id, lek_id) values (1, 21);
--insert into pregled_lekovi (pregled_id, lek_id) values (2, 23);
--insert into pregled_lekovi (pregled_id, lek_id) values (1, 24);
--insert into pregled_lekovi (pregled_id, lek_id) values (2, 25);
--insert into pregled_lekovi (pregled_id, lek_id) values (1, 16);--
--insert into pregled_lekovi (pregled_id, lek_id) values (3, 13);

insert into simptom (name) values ('Seizure');
insert into simptom (name) values ('Abnormal involuntary movements');
insert into simptom (name) values ('Problems with movements');
insert into simptom (name) values ('Headache');
insert into simptom (name) values ('Dizziness');
insert into simptom (name) values ('Disturbance of memory');
insert into simptom (name) values ('Weakness');
insert into simptom (name) values ('Leg pain');
insert into simptom (name) values ('Sleepiness');
insert into simptom (name) values ('Apnea');
insert into simptom (name) values ('Depression');
insert into simptom (name) values ('Sharp chest pain');
insert into simptom (name) values ('Shortness of breath');
insert into simptom (name) values ('Insomnia');
insert into simptom (name) values ('Nervousness');
insert into simptom (name) values ('Delusions or hallucinations');
insert into simptom (name) values ('Nausia');
insert into simptom (name) values ('Vomiting');
insert into simptom (name) values ('Cough');
insert into simptom (name) values ('Sore throat');
insert into simptom (name) values ('Fever');
insert into simptom (name) values ('Knee pain');
insert into simptom (name) values ('Back pain');

insert into test (name) values ('Radiographic imaging procedure');
insert into test (name) values ('Hematologic tests');
insert into test (name) values ('Complete blood count');
insert into test (name) values ('X ray');
insert into test (name) values ('Glucose measurement');
insert into test (name) values ('Intravenous fluid replacement');
insert into test (name) values ('Kidney function tests');
insert into test (name) values ('Magnetic resonance imaging');
insert into test (name) values ('Physical therapy exercises');
insert into test (name) values ('Ophthalmic examination and evaluation');
insert into test (name) values ('Depression screen');
insert into test (name) values ('Speech therapy');
insert into test (name) values ('Hemoglobin A1c test');
insert into test (name) values ('Lipid panel');
insert into test (name) values ('Psychotherapy');
insert into test (name) values ('Electrocardiogram');
insert into test (name) values ('Mental health counseling');
insert into test (name) values ('Cardiac monitoring');
insert into test (name) values ('CAT scan of head');
insert into test (name) values ('Influenzavirus');
insert into test (name) values ('Nebulizer therapy');
insert into test (name) values ('Other terapeutic ear procedures');
insert into test (name) values ('Diagnostic procedures on nose');
insert into test (name) values ('Splinting');
insert into test (name) values ('Toxicology screen');

insert into pregled_simptomi (pregled_id, simptom_id) values (1, 2);		
insert into pregled_simptomi (pregled_id, simptom_id) values (1, 3);		
insert into pregled_simptomi (pregled_id, simptom_id) values (1, 4);		
insert into pregled_simptomi (pregled_id, simptom_id) values (1, 5);		
insert into pregled_simptomi (pregled_id, simptom_id) values (1, 1);		

insert into pregled_simptomi (pregled_id, simptom_id) values (2, 2);		
insert into pregled_simptomi (pregled_id, simptom_id) values (2, 3);		
insert into pregled_simptomi (pregled_id, simptom_id) values (2, 6);		
insert into pregled_simptomi (pregled_id, simptom_id) values (2, 5);		

insert into pregled_simptomi (pregled_id, simptom_id) values (3, 2);		
insert into pregled_simptomi (pregled_id, simptom_id) values (3, 8);		
insert into pregled_simptomi (pregled_id, simptom_id) values (3, 4);		
insert into pregled_simptomi (pregled_id, simptom_id) values (3, 9);		
insert into pregled_simptomi (pregled_id, simptom_id) values (3, 10);		

insert into pregled_simptomi (pregled_id, simptom_id) values (4, 15);		
insert into pregled_simptomi (pregled_id, simptom_id) values (4, 11);		
insert into pregled_simptomi (pregled_id, simptom_id) values (4, 12);	
insert into pregled_simptomi (pregled_id, simptom_id) values (4, 13);		
insert into pregled_simptomi (pregled_id, simptom_id) values (4, 4);		

insert into pregled_simptomi (pregled_id, simptom_id) values (5, 1);		
insert into pregled_simptomi (pregled_id, simptom_id) values (5, 4);		
insert into pregled_simptomi (pregled_id, simptom_id) values (5, 2);		
insert into pregled_simptomi (pregled_id, simptom_id) values (5, 6);		

insert into pregled_simptomi (pregled_id, simptom_id) values (6, 11);		
insert into pregled_simptomi (pregled_id, simptom_id) values (6, 15);		
insert into pregled_simptomi (pregled_id, simptom_id) values (6, 16);		

insert into pregled_simptomi (pregled_id, simptom_id) values (7, 4);		
insert into pregled_simptomi (pregled_id, simptom_id) values (7, 17);		
insert into pregled_simptomi (pregled_id, simptom_id) values (7, 18);		

insert into pregled_simptomi (pregled_id, simptom_id) values (8, 11);		
insert into pregled_simptomi (pregled_id, simptom_id) values (8, 1);		
insert into pregled_simptomi (pregled_id, simptom_id) values (8, 16);		

insert into pregled_simptomi (pregled_id, simptom_id) values (9, 19);		
insert into pregled_simptomi (pregled_id, simptom_id) values (9, 20);		
insert into pregled_simptomi (pregled_id, simptom_id) values (9, 21);		

insert into pregled_simptomi (pregled_id, simptom_id) values (10, 19);		
insert into pregled_simptomi (pregled_id, simptom_id) values (10, 4);		
insert into pregled_simptomi (pregled_id, simptom_id) values (10, 20);		
insert into pregled_simptomi (pregled_id, simptom_id) values (10, 21);		

insert into pregled_simptomi (pregled_id, simptom_id) values (11, 22);		
insert into pregled_simptomi (pregled_id, simptom_id) values (11, 23);		
insert into pregled_simptomi (pregled_id, simptom_id) values (11, 4);		
insert into pregled_simptomi (pregled_id, simptom_id) values (11, 8);		

insert into pregled_simptomi (pregled_id, simptom_id) values (12, 6);		
insert into pregled_simptomi (pregled_id, simptom_id) values (12, 11);		
insert into pregled_simptomi (pregled_id, simptom_id) values (12, 3);		
insert into pregled_simptomi (pregled_id, simptom_id) values (12, 16);		

insert into pregled_simptomi (pregled_id, simptom_id) values (13, 6);		
insert into pregled_simptomi (pregled_id, simptom_id) values (13, 11);		
insert into pregled_simptomi (pregled_id, simptom_id) values (13, 3);		
insert into pregled_simptomi (pregled_id, simptom_id) values (13, 16);		
insert into pregled_simptomi (pregled_id, simptom_id) values (13, 2);		

insert into pregled_simptomi (pregled_id, simptom_id) values (14, 11);		
insert into pregled_simptomi (pregled_id, simptom_id) values (14, 15);		
insert into pregled_simptomi (pregled_id, simptom_id) values (14, 14);		
insert into pregled_simptomi (pregled_id, simptom_id) values (14, 16);		

insert into pregled_simptomi (pregled_id, simptom_id) values (15, 6);			
insert into pregled_simptomi (pregled_id, simptom_id) values (15, 3);		
insert into pregled_simptomi (pregled_id, simptom_id) values (15, 5);	
insert into pregled_simptomi (pregled_id, simptom_id) values (15, 11);		
insert into pregled_simptomi (pregled_id, simptom_id) values (15, 2);

insert into pregled_testovi (pregled_id, test_id) values (1, 8);		
insert into pregled_testovi (pregled_id, test_id) values (1, 9);		
insert into pregled_testovi (pregled_id, test_id) values (1, 10);		

insert into pregled_testovi (pregled_id, test_id) values (2, 8);
insert into pregled_testovi (pregled_id, test_id) values (2, 10);
insert into pregled_testovi (pregled_id, test_id) values (2, 11);		
insert into pregled_testovi (pregled_id, test_id) values (2, 12);		

insert into pregled_testovi (pregled_id, test_id) values (3, 14);		
insert into pregled_testovi (pregled_id, test_id) values (3, 13);		
insert into pregled_testovi (pregled_id, test_id) values (3, 8);		
insert into pregled_testovi (pregled_id, test_id) values (3, 11);		

insert into pregled_testovi (pregled_id, test_id) values (4, 15);		
insert into pregled_testovi (pregled_id, test_id) values (4, 16);
insert into pregled_testovi (pregled_id, test_id) values (4, 17);		
insert into pregled_testovi (pregled_id, test_id) values (4, 18);		

insert into pregled_testovi (pregled_id, test_id) values (5, 2);	
insert into pregled_testovi (pregled_id, test_id) values (5, 3);
insert into pregled_testovi (pregled_id, test_id) values (5, 4);
insert into pregled_testovi (pregled_id, test_id) values (5, 8);

insert into pregled_testovi (pregled_id, test_id) values (6, 2);
insert into pregled_testovi (pregled_id, test_id) values (6, 3);
insert into pregled_testovi (pregled_id, test_id) values (6, 17);		
insert into pregled_testovi (pregled_id, test_id) values (6, 15);		

insert into pregled_testovi (pregled_id, test_id) values (7, 6);		
insert into pregled_testovi (pregled_id, test_id) values (7, 4);		
insert into pregled_testovi (pregled_id, test_id) values (7, 8);	
insert into pregled_testovi (pregled_id, test_id) values (7, 19);		

insert into pregled_testovi (pregled_id, test_id) values (8, 15);		
insert into pregled_testovi (pregled_id, test_id) values (8, 17);		
insert into pregled_testovi (pregled_id, test_id) values (8, 12);		
insert into pregled_testovi (pregled_id, test_id) values (8, 8);

insert into pregled_testovi (pregled_id, test_id) values (9, 20);
insert into pregled_testovi (pregled_id, test_id) values (9, 21);
insert into pregled_testovi (pregled_id, test_id) values (9, 22);

insert into pregled_testovi (pregled_id, test_id) values (10, 4);
insert into pregled_testovi (pregled_id, test_id) values (10, 20);
insert into pregled_testovi (pregled_id, test_id) values (10, 23);

insert into pregled_testovi (pregled_id, test_id) values (11, 1);
insert into pregled_testovi (pregled_id, test_id) values (11, 4);
insert into pregled_testovi (pregled_id, test_id) values (11, 11);
insert into pregled_testovi (pregled_id, test_id) values (11, 24);

insert into pregled_testovi (pregled_id, test_id) values (12, 16);	
insert into pregled_testovi (pregled_id, test_id) values (12, 17);
insert into pregled_testovi (pregled_id, test_id) values (12, 4);		
insert into pregled_testovi (pregled_id, test_id) values (12, 15);	

insert into pregled_testovi (pregled_id, test_id) values (13, 2);
insert into pregled_testovi (pregled_id, test_id) values (13, 3);
insert into pregled_testovi (pregled_id, test_id) values (13, 5);
insert into pregled_testovi (pregled_id, test_id) values (13, 16);

insert into pregled_testovi (pregled_id, test_id) values (14, 15);
insert into pregled_testovi (pregled_id, test_id) values (14, 17);
insert into pregled_testovi (pregled_id, test_id) values (14, 11);		
insert into pregled_testovi (pregled_id, test_id) values (14, 25);

insert into pregled_testovi (pregled_id, test_id) values (15, 16);
insert into pregled_testovi (pregled_id, test_id) values (15, 4);
insert into pregled_testovi (pregled_id, test_id) values (15, 17);
insert into pregled_testovi (pregled_id, test_id) values (15, 14);

--insert into pregled_dijagnoza (pregled_id, dijagnoza_id) values (1, 5);
--insert into pregled_dijagnoza (pregled_id, dijagnoza_id) values (2, 5);
--insert into pregled_dijagnoza (pregled_id, dijagnoza_id) values (2, 3);
--insert into pregled_dijagnoza (pregled_id, dijagnoza_id) values (4, 4);
--insert into pregled_dijagnoza (pregled_id, dijagnoza_id) values (2, 4);
--insert into pregled_dijagnoza (pregled_id, dijagnoza_id) values (3, 5);
--insert into pregled_dijagnoza (pregled_id, dijagnoza_id) values (3, 4);
--insert into pregled_dijagnoza (pregled_id, dijagnoza_id) values (4, 2);
--insert into pregled_dijagnoza (pregled_id, dijagnoza_id) values (2, 1);
--insert into pregled_dijagnoza (pregled_id, dijagnoza_id) values (3, 1);
--insert into pregled_dijagnoza (pregled_id, dijagnoza_id) values (1, 1);
--insert into pregled_dijagnoza (pregled_id, dijagnoza_id) values (4, 1);


