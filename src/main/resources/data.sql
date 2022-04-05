INSERT INTO NEWS (ID, NAME, TEXT, DATE)
VALUES (nextval('NEWS_SEQ'), 'How sleep and mental health were affected in Sweden during the COVID-19 pandemic',
        'The outbreak of SARS-CoV-2 in late 2019 is one of the most life-changing catastrophes in modern history. As a result of the non-pharmaceutical measures placed by the nations to curb the coronavirus disease 2019 (COVID-19) pandemic, many people experienced drastic changes in work, communication, and even leisure pursuits.
        Although Sweden, unlike most nations, was not subjected to a tight lockdown during the pandemic, additional measures such as border closures, travel restrictions, and working from home were implemented that helped stop the spread of SARS-CoV-2.
        However, these preventive measures caused some negative effects, including increased loneliness, worry about loss of income, and job insecurity. Data from previous studies indicate that the COVID-19 pandemic has led to anxiety, stress, depression, and changes in sleep patterns of populations in many regions around the globe.',
        '1997-07-07');

INSERT INTO NEWS (ID, NAME, TEXT, DATE)
VALUES (nextval('NEWS_SEQ'), 'How Could Smart Bandages Revolutionize Wound Care?',
        'Today, these familiar materials are being replaced by modern bandages of a new generation, which are made from natural and synthetic materials that have unique wound healing properties. ' ||
        'Thanks to the achievements of modern medicine, the process of treating wounds of various natures has become faster and more efficient. For correct treatment, an approach is used that combines ' ||
        'drug treatment, antibiotic therapy and, if necessary, surgical repair of tissue connections (suturing). The choice of approach depends on the degree of damage, localization and nature of the wound. ' ||
        'There are wounds that occur because of metabolic disorders or prolonged bed rest. This type of wound can include, for example, bedsores, trophic ulcers, or diabetic foot ulcers. For wounds associated ' ||
        'with mechanical damage as a result of external influences (for example, burns, postoperative wounds), the treatment process will be associated with the restoration of the anatomical integrity of tissues and ' ||
        'often treatment is associated with surgical intervention.',
        '1997-07-07');

INSERT INTO NEWS (ID, NAME, TEXT, DATE)
VALUES (nextval('NEWS_SEQ'), 'The Effect of Diet on Mental Health',
        'The brain controls and regulates most of the body’s vital functions, conscious or not. For this reason, it is essential that the brain receives a steady supply of fuel and oxygen. The fuel is obtained by metabolizing nutrients made available in the bloodstream, originating in the digested food.
         The brain consumes 20% of the daily intake of calories, that is, about 400 (out of 2000) calories a day. Structurally, about 60% of the brain is fat, comprising of high cholesterol and polyunsaturated fatty acids (PUFAs).',
        '2022-06-22');

INSERT INTO NEWS (ID, NAME, TEXT, DATE)
VALUES (nextval('NEWS_SEQ'), 'What are the Health Effects of Ultra-Processed Vegan Foods?',
        'The estrogen component prevents the increase in follicle-stimulating hormone (FSH), thus inhibiting the formation of a dominant follicle. The progestin molecule inhibits luteinizing hormone (LH) secretion and thus keeps the LH surge from occurring. Both together prevent the occurrence of ovulation.
        Progesterone is not normally present at significant levels in the non-luteal phase of the normal menstrual cycle. During the luteal phase, the endometrium has already become thickened and it is now decidualized by the action of progesterone. With a combined OCP, the progesterone shows stronger activity than the estrogen, causing the endometrium to become thin but decidualized.',
        '2022-06-22');

INSERT INTO NEWS (ID, NAME, TEXT, DATE)
VALUES (nextval('NEWS_SEQ'), 'Why Can Women Fight COVID-19 Better Than Men?',
        'An outbreak of COVID-19 was first detected in Wuhan city of China in December 2019. The causative pathogen of COVID-19 is known as SARS-CoV-2, an enveloped, positive-sense, single-stranded RNA virus belonging to the human beta-coronavirus family.
        Although about 80% of COVID-19 patients develop only mild symptoms, the risk of severe infection is significantly higher among elderly people, comorbid patients, and immunocompromised patients.',
        '2022-06-22');


INSERT INTO NEWS (ID, NAME, TEXT, DATE)
VALUES (nextval('NEWS_SEQ'), 'Overweight Patients Should Slim Down Before Procedure To Treat Abnormal Heart Rhythm',
        'Atrial fibrillation is the most common heart rhythm disorder worldwide. It is estimated that one in three Europeans will develop the condition. Atrial fibrillation is associated with elevated risks of stroke, heart failure and premature death, while more than 60% of patients have impaired quality of life. Dr. Toennesen said: "The potential for deleterious outcomes means that obtaining a normal heart rhythm is a crucial goal of treatment."
        Treatment options include drugs and ablation, which involves burning or freezing a small portion of the heart to create a scar and prevent the spread of abnormal electrical impulses. While previous research has shown that obesity is associated with the development of atrial fibrillation, this study examined the link between BMI and a return of the heart rhythm disorder after ablation.',
        '2022-06-22');





INSERT INTO SERVICES(ID, NAME, PROC_INFORMATION,CAN_INFORMATION)
VALUES (nextval('SERVICES_SEQ'), 'Facelift',
        'Rhytidectomy, a surgical procedure commonly known as a facelift, involves the removal of excess facial fat, the tightening of facial muscles, and the stretching of facial skin to approximate a smoother, firmer facial appearance. The procedure takes place on either the face, neck, or both.Depending on the area of the face or neck where the "lift" is to take place, the surgeon will separate the skin from the fat and muscle. The fat is then removed and the skin is pulled back into place with any excess removed.',
        'The best candidates for a facelift are those whose face and/or neck have begun to sag, but whose skin still has some elasticity. The procedure also works best on persons whose bone structure is strong and well-defined.');

INSERT INTO SERVICES(ID, NAME, PROC_INFORMATION,CAN_INFORMATION)
VALUES (nextval('SERVICES_SEQ'), 'Forehead Lift',
        'A forehead lift is the surgical removal of excess fat and skin, as well as a tightening of the muscles in the forehead area. It can correct sagging brows or deep furrows between the eyes. It is often done in conjunction with a facelift, in order to create a smoother facial appearance overall.',
        'A forehead lift can help people of any age who have developed furrows or frown lines due to stress, muscle activity, or inherited conditions, such as a low, heavy brow or furrowed lines above the nose. However, it is most commonly performed on people ages 40 to 60, to minimize the visible effects of aging.Forehead lift is often performed in conjunction with a facelift or eyelid lift surgery.');

INSERT INTO SERVICES(ID, NAME, PROC_INFORMATION,CAN_INFORMATION)
VALUES (nextval('SERVICES_SEQ'), 'Eyelid Surgery',
        'The tone and shape of eyelids can loosen and sag with time. An eyelid lift, or blepharoplasty, can correct this. During the procedure, your physician surgically removes excess fat, muscle and skin from both the upper and lower eyelids to redefine the shape of the eye.',
        'There may be other side effects and complications from the procedure. We work with you to minimize these complications and manage any discomfort you may experience. Learn more about eyelid surgery complications.');

INSERT INTO SERVICES(ID, NAME, PROC_INFORMATION,CAN_INFORMATION)
VALUES (nextval('SERVICES_SEQ'), 'Nasal Surgery',
        'Nasal surgery includes any surgery performed on the outside or inside of the nose. Nasal obstruction is usually the result of anatomic and functional problems, which can cause dysfunctional airflow in the upper airway, therefore playing an important role in OSA and snoring, and also can prevent CPAP use. The cause of nasal airflow problems can be a deviated nasal septum, enlarged nasal turbinates, narrowing or collapse of the nasal opening, nasal polyps, swollen nasal mucosa due to allergies or other irritants or commonly a combination of all.',
        'Usually medical treatment options are the initial choice to target nasal obstruction, including nasal saline irrigations, steroids and antihistamine sprays, oral medication and an allergist evaluation. External nasal dilators as the Breathe Right® nasal strips can be used for some cases with narrowed or collapsible nasal aperture. When medical treatment alone isn''t successful, surgery can improve the nasal airway either alone or in combination with these options.');

INSERT INTO SERVICES(ID, NAME, PROC_INFORMATION,CAN_INFORMATION)
VALUES (nextval('SERVICES_SEQ'), 'Cleft Lip and Cleft Palate',
        'Cleft lip and cleft palate are birth abnormalities of the mouth and lip. These abnormalities affect about one in every 700 births and are more common among Asians and certain groups of American Indians than among Caucasians. They occur less frequently among African-Americans. Cleft lip and cleft palate occur early in pregnancy when the sides of the lip and the roof of the mouth do not fuse together as they should. A child can have cleft lip, cleft palate, or both. Cleft lip and cleft palate together are more common in boys. It is also important to know that most babies born with a cleft are otherwise healthy with no other birth abnormalities',
        'Cleft palate occurs when the roof of the mouth does not completely close, leaving an opening that can extend into the nasal cavity. The cleft may involve either side of the palate. It can extend from the front of the mouth (hard palate) to the throat (soft palate). Often the cleft will also include the lip. Cleft palate is not as noticeable as cleft lip because it is inside the mouth. It may be the only abnormality in the child, or it may be associated with cleft lip or other syndromes. In many cases, other family members have also had a cleft palate at birth.');

INSERT INTO SERVICES(ID, NAME, PROC_INFORMATION,CAN_INFORMATION)
VALUES (nextval('SERVICES_SEQ'), 'Liposuction',
        'Liposuction is a procedure that removes excess fat through a suctioning process. Although it is not a substitute for weight loss, it is a way of changing the body''s shape and contour. Women usually have liposuction performed under the chin, on the hips, thighs, and stomach, and in the under arm and breast areas. In women, the single most frequently treated areas are the outer thighs, followed by the stomach. Men usually have liposuction performed under the chin and around the waist, or in the reduction of enlarged male breasts, a condition known as gynecomastia. In men, the waist area or "love handles" are most frequently treated.',
        'Generally, people of normal weight who have localized areas of protruding fat achieve the most desired results, however, persons who are slightly overweight can also benefit from liposuction. The best candidates for liposuction include the following: Normal-weight (or slightly-overweight) people, People with firm, elastic skin, People who have pockets of excess fat in certain areas, Physically healthy and psychologically stable people, People with realistic expectations. Age is not a major factor, although older persons with diminished skin elasticity may not have the same results as persons with tighter skin.');

INSERT INTO SERVICES(ID, NAME, PROC_INFORMATION,CAN_INFORMATION)
VALUES (nextval('SERVICES_SEQ'), 'Chemical Peel',
        'We use food sugars and other carefully chosen chemicals to safely peel away some of your old skin, leaving new skin that may be smoother and less wrinkled. In many cases, treatment may require multiple peels. This treatment is designed to enhance the appearance of your skin. For some people, the treatment may help enhance self-confidence too.',
        'Our doctors have the experience and training to know which chemical peel will benefit you most: a light, medium or deep approach. They can apply a peel on your face, neck, chest, hands, arms, and legs.');

INSERT INTO SERVICES(ID, NAME, PROC_INFORMATION,CAN_INFORMATION)
VALUES (nextval('SERVICES_SEQ'), 'Varicose veins',
        'The goals of varicose vein treatment are to reduce symptoms and prevent complications. For some, the goal may be improved appearance. Home treatment is typically the first approach.',
        'Some people may want to improve how their legs look, even though their varicose veins aren''t causing other problems. In these cases, a procedure may be a good option, as long as there are no other health problems that make these treatments risky.');

INSERT INTO SERVICES(ID, NAME, PROC_INFORMATION,CAN_INFORMATION)
VALUES (nextval('SERVICES_SEQ'), 'Hair Replacement Surgery',
        'The interest in hair replacement has significantly increased over the past ten years. Two out of every three men, and one in five women, suffer from hair loss. For men, the main cause of a diminishing hairline is heredity. Hormonal changes such as menopause can cause both thinning and hair loss in women. There are a number of hair replacement techniques that are available, although hair replacement surgery cannot help those who suffer from total baldness. Candidates for hair replacement must have a healthy growth of hair at the back and sides of the head. The hair on the back and sides of the head will serve as hair donor areas where grafts and flaps will be taken.',
        'Generally, people of normal weight who have localized areas of protruding fat achieve the most desired results, however, persons who are slightly overweight can also benefit from liposuction. The best candidates for liposuction include the following: Normal-weight (or slightly-overweight) people, People with firm, elastic skin, People who have pockets of excess fat in certain areas, Physically healthy and psychologically stable people, People with realistic expectations. Age is not a major factor, although older persons with diminished skin elasticity may not have the same results as persons with tighter skin.');


