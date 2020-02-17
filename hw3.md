**From:** Xinhao Liao  
**To:** Raj Kumar  
**Date:** Week 3  

Hi Raj,  

I have checked the database and am able to answer these questions now. The query records are appended in the end. The code for querying tweet data is appended in *tweet.py*. And the updated documentation is appended in *documentation.pdf*.  

For question about revenue,  
* 245 Ann Arbor-based companies (rows) are listed in the database in 2014.  
* A list of the names of ALL of the companies that generated more than $10,000,000,000 (ten billion dollars) in 2014 is shown below. There are 19 companies in total.   

```
+---------------------------------------------------------------+
| name                                                          |
+---------------------------------------------------------------+
| IHC HEALTH SERVICES INC                                       |
| CENTRAL STATES SE & SW AREAS HEALTH & WELFARE F               |
| Banner Health                                                 |
| KAISER FOUNDATION HEALTH PLAN INC                             |
| Thrivent Financial for Lutherans                              |
| UAW RETIREE MEDICAL BENEFITS TRUST                            |
| KAISER FOUNDATION HOSPITALS                                   |
| Massachusetts Institute of Technology                         |
| UPMC GROUP                                                    |
| Cornell University                                            |
| Trustees of the University of Pennsylvania                    |
| President and Fellows of Harvard College                      |
| YALE UNIVERSITY                                               |
| STATE EMPLOYEES' CREDIT UNION                                 |
| DUKE UNIVERSITY                                               |
| Howard Hughes Medical Institute                               |
| Partners HealthCare System Inc & AffiliatesGroup Return       |
| THE BOARD OF TRUSTEES OF THE LELAND STANFORDJUNIOR UNIVERSITY |
| DIGNITY HEALTH                                                |
+---------------------------------------------------------------+
```  

* As for unique companies generated a revenue of more than $1,000,000,000 (one billion dollars) in any year, there are 404 companies in total as listed below.  
```
+-----------------------------------------------------------------------------+
| name                                                                        |
+-----------------------------------------------------------------------------+
| PROVIDENCE HEALTH SYSTEM -SO CALIFORNIA                                     |
| SUTTER HEALTH SACRAMENTO SIERRA REGION                                      |
| Children's Healthcare of Atlanta Inc                                        |
| Healthfirst PHSP Inc                                                        |
| KALEIDA HEALTH                                                              |
| KAISER FOUNDATION HEALTH PLAN OF COLORADOINC                                |
| TEAMSTERS WESTERN REGION AND NEW JERSEYHEALTH CARE FUND                     |
| NATIONAL AUTOMATIC SPRINKLER INDUSTRY WELFARE FUND                          |
| IHC HEALTH SERVICES INC                                                     |
| Security Health Plan of Wisconsin Inc                                       |
| The Boeing Company Veba Master Trust                                        |
| AMERICAN POSTAL WORKERS UNION AFL CIO HEALTH                                |
| MAYO CLINIC HOSPITAL - ROCHESTER                                            |
| THE NEMOURS FOUNDATION                                                      |
| LONG ISLAND JEWISH MEDICAL CENTERC/O NORTH SHORE-LIJ HEALTH SYSTEM          |
| INDIANA UNIVERSITY HEALTH INC                                               |
| Santa Barbara Cottage Hospital                                              |
| MOTION PICTURE INDUSTRY HEALTH PLAN                                         |
| SSM Health Care St Louis                                                    |
| Atlantic Health System Inc Group Return                                     |
| CENTRAL STATES SE & SW AREAS HEALTH & WELFARE F                             |
| West Penn Allegheny Health System Inc                                       |
| METHODIST HOSPITAL GROUP                                                    |
| HACKENSACK UNIVERSITY MEDICAL CENTER                                        |
| BOY SCOUTS OF AMERICA                                                       |
| Charleston Area Medical Center Inc                                          |
| American Electric Power System EmployeesBenefit Trust                       |
| Miami Valley Hospital                                                       |
| PARK NICOLLET GROUP RETURN                                                  |
| MERITER HOSPITAL INC                                                        |
| SEVENTH-DAY ADVENTISTS LOMA LINDAUNIVERSITY MEDICAL CENTER                  |
| FRANCISCAN ALLIANCE INC                                                     |
| Aurora Health Care Inc Group Return                                         |
| FORSYTH MEMORIAL HOSPITAL                                                   |
| NOVANT HEALTH INC                                                           |
| Priority Health                                                             |
| The Cooper Health System a New JerseyNon-Profit Corporation                 |
| UNITED STEEL PAPER AND FORESTRYRUBBER MANUFACTURING ENERGY ALLIED           |
| UNITE HERE HEALTH                                                           |
| NATIONAL ELEVATOR INDUSTRY HEALTH BENEFIT PLAN                              |
| KAISER FOUNDATION HEALTH PLAN INC                                           |
| KNIGHTS OF COLUMBUS                                                         |
| BayCare Health System Inc                                                   |
| Palos Community Hospital                                                    |
| SCAN HEALTH PLAN                                                            |
| Banner Health                                                               |
| KAISER FOUNDATION HOSPITALS                                                 |
| MAYO FOUNDATION FOR MEDICAL EDUCATION AND RESEARCH                          |
| VNS CHOICE                                                                  |
| KAISER FOUNDATION HEALTH PLANOF THE NORTHWEST INC                           |
| HARVARD VANGUARD MEDICAL ASSOCIATES INC                                     |
| ALLINA HEALTH SYSTEM                                                        |
| SELECTHEALTH INC                                                            |
| Educational Testing Service                                                 |
| Thrivent Financial for Lutherans                                            |
| GROUP HEALTH COOPERATIVE                                                    |
| THE TOLEDO HOSPITAL                                                         |
| Nationwide Children's Hospital Group Return                                 |
| SENTARA HEALTHCARE                                                          |
| THE EVANGELICAL LUTHERAN GOOD SAMARITAN SOCIETY                             |
| MULTICARE HEALTH SYSTEM                                                     |
| KAISER FOUNDATION HEALTH PLAN OF THEMID-ATLANTIC STATES INC                 |
| FINANCIAL INDUSTRY REGULATORY AUTHORITY INC                                 |
| Ochsner Clinic Foundation                                                   |
| PRESBYTERIAN HEALTHCARE SERVICES                                            |
| KAISER FOUNDATION HEALTH PLAN OF GEORGIA INC                                |
| CAPITAL DISTRICT PHYSICIANS' HEALTH PLAN INC                                |
| METHODIST HEALTHCARE - MEMPHIS HOSPITALS                                    |
| KAISER FOUNDATION HEALTH PLAN OF GEORGIAINC                                 |
| Children's Medical Center of Dallas                                         |
| CENTRA HEALTH INC                                                           |
| OAKWOOD HEALTHCARE INC                                                      |
| GROUP HEALTH PLAN INC                                                       |
| Maimonides Medical Center                                                   |
| Memorial Sloan-Kettering Cancer Center                                      |
| PGA TOUR INC                                                                |
| American Bureau of Shipping                                                 |
| Children's Healthcare of Atlanta Group Return                               |
| SWEDISH HEALTH SERVICES                                                     |
| Virginia Mason Medical Center                                               |
| HEALTH SHARE OF OREGON                                                      |
| SUTTER EAST BAY HOSPITALS                                                   |
| SOUTHERN CALIFORNIA EDISON CO VEBA                                          |
| UAW RETIREE MEDICAL BENEFITS TRUST                                          |
| 1199SEIU NATIONAL BENEFIT FUND FORHEALTH AND HUMAN SERVICE EMPLOYEES        |
| Tufts Associated Health MaintenanceOrganization Inc                         |
| UNITED STATES STEEL CORPORATIONREPRESENTED RETIREES BENEFIT TRUST           |
| THE CLEVELAND CLINIC FOUNDATION                                             |
| MONTEFIORE MEDICAL CENTER                                                   |
| BETH ISRAEL MEDICAL CENTER                                                  |
| MANAGEMENT-ILA MANAGED HEALTHCARE TRUST FUND                                |
| Winthrop University Hospital Association                                    |
| BRAZOS ELECTRIC POWER COOPERATIVE INC                                       |
| St Elizabeth Medical Center Inc                                             |
| HEALTHPLUS OF MICHIGAN                                                      |
| STATEN ISLAND UNIVERSITY HOSPITAL                                           |
| PALO ALTO MEDICAL FOUNDATION                                                |
| PRESENCE HOSPITALS PRV                                                      |
| St George Corporation                                                       |
| JOHN MUIR HEALTH                                                            |
| FEEDING AMERICA                                                             |
| Summa Health Group Return                                                   |
| UNIVERSITY OF WISCONSIN FOUNDATION                                          |
| THE NEW YORK AND PRESBYTERIAN HOSPITAL                                      |
| WILLIAM BEAUMONT HOSPITAL                                                   |
| AFFINITY HEALTH PLAN INC                                                    |
| PROVIDENCE HEALTH & SERVICES - OREGON                                       |
| Children's Health Care                                                      |
| BLUE CARE NETWORK OF MICHIGAN                                               |
| GRADY MEMORIAL HOSPITAL CORPORATION                                         |
| CareSource                                                                  |
| THE MOUNT SINAI HOSPITAL                                                    |
| MVP HEALTH PLAN INC                                                         |
| KAISER FOUNDATION HEALTH PLANOF THE NORTHWEST                               |
| AMERICAN CHEMICAL SOCIETY                                                   |
| Aurora Health Care Inc                                                      |
| UNIVERSITY HEALTH SYSTEM INC                                                |
| HENRY FORD HEALTH SYSTEM                                                    |
| Wells Fargo & Co Employee Benefit Trust                                     |
| ROBERT WOOD JOHNSON UNIVERSITY HOSPITAL                                     |
| MEDICA HEALTH PLANS                                                         |
| THE CLEVELAND CLINIC FOUNDATION GROUP RETURN                                |
| GENERAL ELECTRIC INSURANCE PLAN TRUST                                       |
| COMMUNITY HEALTH PLAN OF WASHINGTON                                         |
| Lenox Hill HospitalC/O NORTH SHORE-LIJ HEALTH SYSTEM                        |
| Norton Hospitals Inc                                                        |
| THE METHODIST HOSPITAL                                                      |
| NORTH SHORE-LONG ISLAND JEWISH HEALTH CARE                                  |
| WAL-MART STORES INCASSOCIATES' HEALTH & WELFARE TRUST                       |
| ICAHN SCHOOL OF MEDICINE AT MOUNT SINAI                                     |
| GOVERNMENT EMPLOYEES HEALTH ASSOCIATION INC                                 |
| OPTIMA HEALTH PLAN                                                          |
| SOUTHEASTERN CONFERENCE                                                     |
| Fallon Community Health Plan Inc                                            |
| CITY UNIVERSITY CONSTRUCTION FUND                                           |
| NEIGHBORHOOD HEALTH PLAN INC                                                |
| YOUNG MEN'S CHRISTIAN ASSOCIATION RETIREMENT FUND                           |
| HEALTH ALLIANCE PLAN OF MICHIGAN                                            |
| University Hospitals Health System IncGroup Return                          |
| INTERNATIONAL BROTHERHOOD OF ELECTRICALWORKERS' PENSION BENEFIT FUND        |
| DELTA DENTAL OF CALIFORNIA                                                  |
| University Health Network                                                   |
| HEALTHPARTNERS INC                                                          |
| NEW YORK SOCIETY FOR THE RELIEF OF THERUPTURED AND CRIPPLED MAINTAINING THE |
| Managed Health Inc                                                          |
| THE RESEARCH FOUNDATION FOR THESTATE UNIVERSITY OF NEW YORK                 |
| JEWISH COMMUNAL FUND                                                        |
| TEXAS MUTUAL INSURANCE COMPANY                                              |
| MODERN WOODMEN OF AMERICA                                                   |
| MAYO CLINIC                                                                 |
| WESCOM CENTRAL CREDIT UNIONDBA WESCOM CREDIT UNION                          |
| PROVIDENCE HEALTH & SERVICES - WASHINGTON                                   |
| DELTA DENTAL PLAN OF MICHIGAN INC                                           |
| SUTTER HEALTH                                                               |
| INOVA HEALTH CARE SERVICES                                                  |
| SENTARA HOSPITALS                                                           |
| Adventist Health SystemSunbelt Inc                                          |
| Mercy Health                                                                |
| NATL CHRISTIAN CHARITABLE FDN INC                                           |
| Prairie Meadows Race Track and Casino Inc                                   |
| KAISER FOUNDATION HEALTH PLAN OF COLORADO                                   |
| Texas Health Resources                                                      |
| BJC HEALTH SYSTEM GROUP RETURN                                              |
| CONFERENCE ON JEWISH MATERIAL CLAIMSAGAINST GERMANY INC                     |
| SUTTER WEST BAY HOSPITALS                                                   |
| LINE CONSTRUCTION BENEFIT FUND                                              |
| INDEPENDENT HEALTH ASSOCIATION INC                                          |
| HARVARD PILGRIM HEALTH CARE INC                                             |
| MERIDIAN HEALTH SYSTEM INC - SUBORDINATES                                   |
| Riverside Healthcare Association Inc Group                                  |
| NORTH SHORE UNIVERSITY HOSPITALC/O NORTH SHORE-LIJ HEALTH SYSTEM            |
| Advocate Health And Hospitals Corp                                          |
| AMERICAN HEART ASSOCIATION INC                                              |
| Arizona State University Foundation For A NewAmerican University            |
| Albany Medical Center Group Organization                                    |
| UNITED FOOD & COMMERCIAL WORKERS UNIONS& FOOD EMPLOYERS BENEFIT FUND        |
| UNIVERSITY OF TORONTO                                                       |
| SILICON VALLEY COMMUNITY FOUNDATION                                         |
| ST VINCENT HOSPITAL AND HEALTH CARE CENTER INC                              |
| The Rotary Foundation of Rotary International                               |
| DePaul University                                                           |
| World Vision Inc                                                            |
| OhioHealth Corporation Group Return                                         |
| THE CHANCELLOR MASTER AND SCHOLARSOF THE UNIVERSITY OF CAMBRIDGE            |
| ST LUKE'S-ROOSEVELT HOSPITAL CENTER                                         |
| NATIONAL RURAL UTILITIES COOPERATIVEFINANCE CORPORATION                     |
| COMMUNITY FOUNDATION OF NORTHWEST INDIANAINC                                |
| NORTH CAROLINA BAPTIST HOSPITAL                                             |
| HAWAI'I PACIFIC HEALTH GROUP RETURN                                         |
| SCHWAB CHARITABLE FUND                                                      |
| METROPOLITAN MUSEUM OF ART                                                  |
| CARNEGIE MELLON UNIVERSITY                                                  |
| Massachusetts Institute of Technology                                       |
| UPMC GROUP                                                                  |
| THE MEDSTAR-GEORGETOWN MEDICAL CENTER INC                                   |
| DUKE UNIVERSITY HEALTH SYSTEM INC                                           |
| CAMPBELL UNIVERSITY INC                                                     |
| THE NEW SCHOOL                                                              |
| CHILDREN'S HOSPITAL LOS ANGELES                                             |
| THE CHILDREN'S HOSPITAL OF PHILADELPHIA                                     |
| YORK HOSPITAL                                                               |
| William Marsh Rice University                                               |
| TRUSTEES OF BOSTON UNIVERSITY                                               |
| BILLINGS CLINIC                                                             |
| HARVARD PRIVATE CAPITAL REALTY INCC/O HARVARD MANAGEMENT COMPANY INC        |
| UNIVERSITY OF DAYTON                                                        |
| SYRACUSE UNIVERSITY                                                         |
| PEACEHEALTH                                                                 |
| NORTHSIDE HOSPITAL INC                                                      |
| CHRISTIANA CARE HEALTH SERVICES INC                                         |
| COMMUNICATIONS WORKERS OF AMERICA AFL-CIO CLC                               |
| Our Lady of the Lake Hospital Inc                                           |
| Cornell University                                                          |
| The Chancellor Master & Scholars of the University of Oxford                |
| LIBERTY UNIVERSITY INC                                                      |
| NATIONAL ASSOCIATION OF LETTER CARRIERS                                     |
| COLORADO SEMINARY                                                           |
| TEXAS CHRISTIAN UNIVERSITY                                                  |
| UNIVERSITY OF ROCHESTER                                                     |
| Indiana University Foundation                                               |
| American National Red Cross & Its ConstituentChapters and Branches          |
| PENNSYLVANIA EMPLOYEES BENEFIT TRUST FUND                                   |
| THE COMMON FUND FOR NONPROFIT ORGANIZATIONS                                 |
| Trustees of the University of Pennsylvania                                  |
| Lancaster General Hospital                                                  |
| LEHIGH UNIVERSITY                                                           |
| WILLIS-KNIGHTON MEDICAL CENTER                                              |
| The Queen's Medical Center                                                  |
| TRUSTEES OF BOSTON COLLEGE                                                  |
| President and Fellows of Harvard College                                    |
| YALE UNIVERSITY                                                             |
| PARTNERSHIP FOR SUPPLY CHAIN MANAGEMENT                                     |
| FROEDTERT HEALTH INC                                                        |
| UNIVERSITY OF CHICAGO                                                       |
| NATURE CONSERVANCY                                                          |
| SOUTHERN METHODIST UNIVERSITY                                               |
| THE ROCKEFELLER UNIVERSITY                                                  |
| SWARTHMORE COLLEGE                                                          |
| AMERICAN LEBANESE SYRIAN ASSOCIATED CHARITIES INC                           |
| Vanderbilt University                                                       |
| University of Chicago Medical Ctr                                           |
| Scott & White Memorial Hospital                                             |
| Christus Health                                                             |
| LOYOLA UNIVERSITY MEDICAL CENTER                                            |
| Lehigh Valley Hospital                                                      |
| The Nebraska Medical Center                                                 |
| The Trustees of Princeton University                                        |
| SAINT LOUIS UNIVERSITY                                                      |
| GEISINGER HEALTH PLAN                                                       |
| Baylor College of Medicine                                                  |
| Sanford Group Return                                                        |
| Ascension Health Alliance                                                   |
| UNIVERSITY OF PITTSBURGH                                                    |
| POMONA COLLEGE                                                              |
| GEORGETOWN UNIVERSITY                                                       |
| THE TRUSTEES OF COLUMBIA UNIVERSITYIN THE CITY OF NEW YORK                  |
| The George Washington University                                            |
| Michigan Catastrophic Claims Association                                    |
| CEDARS-SINAI MEDICAL CENTER                                                 |
| University of Southern California                                           |
| FROEDTERT MEMORIAL LUTHERAN HOSPITAL INC                                    |
| ALBERT EINSTEIN HEALTHCARE NETWORK GROUPLETTER RULING                       |
| Mary Hitchcock Memorial Hospital                                            |
| GEISINGER MEDICAL CENTER                                                    |
| HARVARD MANAGEMENT PRIVATE EQUITY CORPC/O HARVARD MANAGEMENT COMPANY INC    |
| MILTON HERSHEY SCHOOL AND SCHOOL TRUST                                      |
| STATE EMPLOYEES' CREDIT UNION                                               |
| Fordham University                                                          |
| Trustees for Harvard University                                             |
| UC Healthcare System                                                        |
| WASHINGTON HOSPITAL CENTER CORPORATION                                      |
| The Children's Mercy Hospital                                               |
| Memorial Hermann Health System                                              |
| Catholic Health Initiatives                                                 |
| CHI St Luke's Health Baylor College of Medicine Medical Center              |
| LOMA LINDA UNIVERSITY                                                       |
| DUKE UNIVERSITY                                                             |
| SHANDS TEACHING HOSPITAL AND CLINICS INC                                    |
| Brown University                                                            |
| NORTHEASTERN UNIVERSITY                                                     |
| Rush University Medical Center                                              |
| Catholic Health Initiatives Colorado                                        |
| MOUNT CARMEL HEALTH SYSTEM                                                  |
| The Medical College of Wisconsin Inc                                        |
| UPMC                                                                        |
| UNIVERSITY OF MARYLAND MEDICAL SYSTEM CORP                                  |
| Temple University Hospital Inc                                              |
| YESHIVA UNIVERSITY                                                          |
| THE UNIVERSITY OF WESTERN ONTARIO                                           |
| THE ADMINISTRATORS OF THE TULANE EDUCATIONAL FUND                           |
| Edward Hospital                                                             |
| PINNACLE HEALTH HOSPITALS                                                   |
| Spectrum Health System Group Return                                         |
| Children's Hospital                                                         |
| Baylor University Medical Center                                            |
| Children's Hospital Medical Center                                          |
| NATIONAL PHILANTHROPIC TRUST                                                |
| JOHNS HOPKINS UNIVERSITY                                                    |
| THE CHILDREN'S HOSPITAL OF PHILADELPHIAFOUNDATION                           |
| MERCY HOSPITALS EAST COMMUNITIES                                            |
| University of Miami                                                         |
| Main Line Hospitals Inc                                                     |
| OhioHealth Corporation                                                      |
| TRINITY HEALTH CORPORATION                                                  |
| Franciscan Health System                                                    |
| AMERICAN BIBLE SOCIETY                                                      |
| DREXEL UNIVERSITY                                                           |
| University of Notre Dame du Lac                                             |
| TRUSTEES OF THE ESTATE OF BERNICE PAUAHIBISHOP                              |
| CALIFORNIA ACADEMY OF SCIENCES                                              |
| CASE WESTERN RESERVE UNIVERSITY                                             |
| MEMORIAL HEALTH SERVICES GROUP RETURN                                       |
| TRINITY HEALTH - MICHIGAN                                                   |
| THE JOHNS HOPKINS HOSPITAL                                                  |
| Trustees of Dartmouth College                                               |
| University of Delaware                                                      |
| Saint Francis Hospital Inc                                                  |
| Temple University - Of the Commonwealth System of Higher Education          |
| BUILDING SERVICE 32BJ HEALTH FUND                                           |
| WASHINGTON UNIVERSITY                                                       |
| NORTH CAROLINA ELECTRIC MEMBERSHIPCORPORATION                               |
| GLOBAL HEALTH SOLUTIONS INC                                                 |
| HOAG MEMORIAL HOSPITAL PRESBYTERIAN                                         |
| MICHIGAN EDUCATION SPECIAL SERVICES ASSN                                    |
| Trustees of Tufts College                                                   |
| THE HOWARD UNIVERSITY                                                       |
| Mercy Hospital Springfield                                                  |
| DELTA PILOTS DISABILITY AND SURVIVOR TRUST                                  |
| Howard Hughes Medical Institute                                             |
| Food For the Poor Inc                                                       |
| PORTERCARE ADVENTIST HEALTH SYSTEM                                          |
| Patient Access Network Foundation                                           |
| REX HOSPITAL INC                                                            |
| City of Hope National Medical Center                                        |
| Marshfield Clinic Inc                                                       |
| MOSES H CONE MEMORIAL HOSPITALOPERATING CORPORATION                         |
| Rhode Island Hospital                                                       |
| BOSTON MEDICAL CENTER                                                       |
| NorthShore University HealthSystem                                          |
| Orlando Health Inc                                                          |
| North Mississippi Medical Center Inc                                        |
| THE MITRE CORPORATION                                                       |
| CUMBERLAND COUNTY HOSPITAL SYSTEM INC                                       |
| PALMETTO HEALTH                                                             |
| CARILION MEDICAL CENTER                                                     |
| Partners HealthCare System Inc & AffiliatesGroup Return                     |
| Hartford Hospital                                                           |
| OSF HEALTHCARE SYSTEM                                                       |
| WakeMed                                                                     |
| NYU HOSPITALS CENTER                                                        |
| ASANTE                                                                      |
| BETH ISRAEL DEACONESS MEDICAL CENTER                                        |
| Children's Hospital Corporation                                             |
| CENTRAL ELECTRIC POWER COOPERATIVE INC                                      |
| Northwestern Memorial HealthCare                                            |
| STANFORD HEALTH CARE                                                        |
| Baptist Healthcare System Inc                                               |
| FLORIDA HEALTH SCIENCES CENTER INC                                          |
| NEW YORK UNIVERSITY                                                         |
| FRESNO COMMUNITY HOSPITAL AND MEDICAL CENTER                                |
| Ann & Robert H Lurie Childrens Hospital ofChicago                           |
| Northwestern University                                                     |
| METROPLUS HEALTH PLAN INC                                                   |
| Northwestern Memorial Healthcare Group                                      |
| SHRINERS HOSPITALS FOR CHILDREN                                             |
| Lucile Salter Packard Children'sHospital at Stanford                        |
| THE BOARD OF TRUSTEES OF THE LELAND STANFORDJUNIOR UNIVERSITY               |
| BAPTIST HOSPITAL OF MIAMI INC                                               |
| Baystate Medical Center Inc                                                 |
| Pitt County Memorial Hospital Inc                                           |
| Sharp Memorial Hospital                                                     |
| GUARANTY ASSOCIATION BENEFITS COMPANY                                       |
| UMASS MEMORIAL HEALTH CARE INC & AFFILIATES                                 |
| BATTELLE MEMORIAL INSTITUTE                                                 |
| Eastern Maine Healthcare Systems EMMCEastern Maine Medical Center           |
| METHODIST HOSPITALS OF DALLAS &PAVILION PROPERTIES                          |
| Dana-Farber Cancer Institute Inc                                            |
| California Institute of Technology                                          |
| WEA INSURANCE CORPORATION                                                   |
| WORKERS' COMPENSATION REINSURANCE ASSOCIATION                               |
| NEW YORK STATE CATHOLIC HEALTH PLANINC                                      |
| LESTER E COX MEDICAL CENTERS                                                |
| Smithsonian Institution                                                     |
| MAINE MEDICAL CENTER                                                        |
| UNITED STUDENT AID FUNDS INC                                                |
| Delta Dental of Washington                                                  |
| BAPTIST HEALTH SOUTH FLORIDAINC                                             |
| EMORY GROUP RETURN                                                          |
| CYSTIC FIBROSIS FOUNDATION- HEADQUARTERS                                    |
| MEMORIAL HEALTH SYSTEM GROUP                                                |
| NATIONAL COLLEGIATE ATHLETIC ASSOCIATION                                    |
| EMORY UNIVERSITY                                                            |
| Scripps Health                                                              |
| THE UNIVERSITY OF VERMONT MEDICAL CENTER INC                                |
| MCLEOD REGIONAL MEDICAL CENTER OFTHE PEE DEE INC                            |
| YALE-NEW HAVEN HOSPITAL                                                     |
| BOSTON MEDICAL CENTER HEALTH PLAN INC                                       |
| SEATTLE CHILDREN'S HOSPITAL                                                 |
| UCare Minnesota                                                             |
| DIGNITY HEALTH                                                              |
| RADY CHILDREN'S HOSPITAL - SAN DIEGO                                        |
| Southern Baptist Hospital of Florida Inc                                    |
| Sharp HealthCare                                                            |
| St Luke's Regional Medical Center                                           |
+-----------------------------------------------------------------------------+
```

For expenses,  
*  The top 20 unique companies by expenses in 2013 and their expenses are shown below.  

```
+---------------------------------------------------------+-------------+
| name                                                    | expenses    |
+---------------------------------------------------------+-------------+
| KAISER FOUNDATION HEALTH PLAN INC                       | 41982288055 |
| UNIVERSITY OF ROCHESTER                                 |  2776536619 |
| ST FRANCIS HOSPITAL AND MEDICAL CENTER                  |   713077460 |
| WELLSTAR HEALTH SYSTEM INC                              |   660400156 |
| SKY LAKES MEDICAL CENTER                                |   488333644 |
| NAPLES COMMUNITY HOSPITAL INC                           |   426168844 |
| YAKIMA VALLEY MEMORIAL HOSPITAL                         |   401985865 |
| EMBRY-RIDDLE AERONAUTICAL UNIVERSITY INC                |   374154000 |
| ST MARY'S HOSPITAL & MEDICAL CENTERINC                  |   372041256 |
| St Barnabas Hospital                                    |   349321637 |
| HOSPITAL COMMITTEE FOR THE LIVERMOREPLEASANTON AREA     |   341257233 |
| VALLEY PRESBYTERIAN HOSPITAL                            |   273789797 |
| WINCHESTER HOSPITAL                                     |   264605951 |
| TEAMSTERS WESTERN REGION AND NEW JERSEYHEALTH CARE FUND |   231059337 |
| OROVILLE HOSPITAL                                       |   200242937 |
| ST JOSEPH HOSPITAL OF EUREKA                            |   196999313 |
| SWARTHMORE COLLEGE                                      |   168742729 |
| ST FRANCIS HOSPITAL - POUGHKEEPSIE                      |   164506124 |
| Vail Clinic Inc                                         |   159617575 |
| TUSKEGEE UNIVERSITY                                     |   152572824 |
+---------------------------------------------------------+-------------+
```  

* For companies that made between $1-100,000 in revenue and between $10000-200,000 in expenses, the list could be too long. So randomly selected 20 companies' EINs and cities are listed here, which are obtained from the query `select distinct ein, city from taxdata where revenue BETWEEN 1 AND 100000 and expenses BETWEEN 10000 AND 200000 order by rand() limit 20;`.  

```
+-----------+---------------+
| ein       | city          |
+-----------+---------------+
| 541945858 | ROCHESTER     |
| 273084801 | Los Angeles   |
| 770319903 | Los Gatos     |
| 431769903 | Van Buren     |
| 521990279 | Silver Spring |
| 930782729 | PORTLAND      |
| 237168819 | NEW BRITAIN   |
| 263613626 | MEMPHIS       |
| 231034791 | GETTYSBURG    |
| 386100681 | Flint         |
| 680657977 | SWARTZ CREEK  |
| 237372144 | Portland      |
| 113649939 | MEXICO        |
| 141865407 | ORISKANY      |
| 521410219 | Germantown    |
| 273558027 | PEEKSKILL     |
| 382896155 | GRAND RAPIDS  |
| 136134882 | STATEN ISLAND |
| 223523449 | Allentown     |
| 710467353 | CLARKSVILLE   |
+-----------+---------------+
```
  
For queries about specific words,  
* There are 261 companies with the word toy anywhere in the ‘purpose’ field, which is obtained from the following query considering all possible occurence of word toy and toys.  
`select count(distinct ein) from taxdata where purpose LIKE "% toy %" or purpose LIKE "% toys %" or purpose LIKE "% toy. %" or  purpose LIKE "% toys. %" or purpose LIKE "toy %" or purpose LIKE "toys %" or purpose LIKE "% toy." or  purpose LIKE "% toys.";`

* There are 2796 rows having both the word ‘smith’ in the ‘ptname’ field and reported revenue (e.g. revenue is not empty or 0).  
* The company names and length of the names for 50 random companies with a ptid of P01345770 are listed below.  

```
+-----------------------------------------------------+----------------+
| name                                                | length of name |
+-----------------------------------------------------+----------------+
| The Rivera Krall Family Foundation                  |             34 |
| The Kao Family Foundation                           |             25 |
| Dixon and Carol Doll Family Foundation              |             38 |
| The Joyce Family Foundation                         |             27 |
| The Burt's Bees Greater Good Foundation             |             39 |
| The Watts Family Foundation                         |             27 |
| Witman Family Foundation                            |             24 |
| The Bess Family Foundation                          |             26 |
| BunnyJack Gives Foundation                          |             26 |
| YDFW Inc                                            |              8 |
| The Caine Family Foundation                         |             27 |
| The El-Erian Family Foundation                      |             30 |
| The Hill Family Charitable Foundation               |             37 |
| Spillers Family Foundation                          |             26 |
| The Migdol Family Foundation Inc                    |             32 |
| The SlimGenics Foundation                           |             25 |
| The Regeneration Foundation                         |             27 |
| Weseley Family Charitable Foundation                |             36 |
| The Surplus Line Association of ArizonaFoundation   |             49 |
| The Foreside Foundation                             |             23 |
| John and Diane Scelfo Charitable Foundation         |             43 |
| The 3 Dimensional Wealth Foundation                 |             35 |
| Monasse Foundation                                  |             18 |
| Barbetta Family Foundation                          |             26 |
| The Wayland E Noland Foundation                     |             31 |
| NewCity Foundation                                  |             18 |
| McKiernan Family Foundation                         |             27 |
| Tom Russell Charitable Foundation Inc               |             37 |
| Chauncey Foundation                                 |             19 |
| William H Wood Family Foundation                    |             32 |
| The Trailviews Foundation                           |             25 |
| The Taking Flight Foundation                        |             28 |
| Gobioff Foundation                                  |             18 |
| Yad Ozer Foundation                                 |             19 |
| Plumeria Family Foundation                          |             26 |
| Flora & Doris Denova Foundation                     |             31 |
| Brigham Family Foundation                           |             25 |
| Trebek Family Foundation                            |             24 |
| The Anne R Monroe Foundation                        |             28 |
| The KL Holbrook Serendipitous Foundation            |             40 |
| AFNOVA Inc                                          |             10 |
| The Loftus Family Foundation                        |             28 |
| William Newkirk and Cheryl Tschanz FamilyFoundation |             51 |
| The King-Guffey Family Foundation                   |             33 |
| Burg Family Foundation                              |             22 |
| Start It Foundation                                 |             19 |
| Bill and Faye Stallings Family Foundation           |             41 |
| The Peter and Michelle Detkin FamilyFoundation      |             46 |
| D&P Roberts Family Foundation                       |             29 |
| The Mark E Pollack Foundation                       |             29 |
+-----------------------------------------------------+----------------+
```  

* The number of companies that have a ‘purpose’ field containing less than 10 characters is 51548.  

For employee's data,  
* We can ues the query `select count(1) from employees where year(hire_date) in (1994,1995,1990);` to query the number of folks that got  hired in 1994, 1995 and 1990. And the result is 52560.  
* For a count of all 'Senior Engineer' that were at the company on 1986-06-26, we can use the query `select count(1) from titles where title = 'Senior Engineer' and from_date <= '1986-06-26' and to_date >= '1986-06-26';` and obtain the result which is 2795.  
* A list of unique names of folks that have had a title of "Engineer" can be queried with `select distinct first_name, last_name from employees where emp_no in (select distinct emp_no from titles where title = 'Engineer');`. Since there are 111930 unique names in total, only 50 of them are randomly selected and listed here.  

```
+-------------+-------------+
| first_name  | last_name   |
+-------------+-------------+
| Xianlong    | Perng       |
| Frazer      | Kitsuregawa |
| Akemi       | Prampolini  |
| Quingbo     | Alblas      |
| LiMin       | Crouzet     |
| Toong       | Feinberg    |
| Girolamo    | Heering     |
| Gadiel      | Karlin      |
| Goo         | Shigei      |
| Godehard    | Merkl       |
| Georg       | Pollock     |
| Danel       | Rodite      |
| Kazuhide    | Kowalchuk   |
| Dipayan     | Kugler      |
| Zhensheng   | Hiyoshi     |
| Shay        | Delaune     |
| Chiranjit   | Velardi     |
| Almudena    | Comte       |
| Moni        | Trelles     |
| Krister     | Brendel     |
| Bouchung    | Adachi      |
| Cullen      | Kopetz      |
| Rasikan     | Veevers     |
| Golgen      | Lally       |
| Bartek      | Honglei     |
| Aris        | Legleitner  |
| Takahiro    | Murthy      |
| True        | Capobianchi |
| Constantino | Liesche     |
| Ranga       | Baak        |
| Jacopo      | Erie        |
| Moie        | Danner      |
| Trygve      | Wegerle     |
| Elvis       | Pusterhofer |
| Debatosh    | Ernst       |
| Brewster    | Schaad      |
| Mana        | Griswold    |
| Kendra      | Scharstein  |
| Dmitri      | Stavenow    |
| Hercules    | Maliniak    |
| Dulce       | Kisuki      |
| Shietung    | Skafidas    |
| Sajjad      | Ramaiah     |
| Thanasis    | Percebois   |
| Baziley     | Oxenboll    |
| Sanjiv      | Dredge      |
| Jiang       | Emmerich    |
| Florina     | Potthoff    |
| Saeko       | Wendorf     |
| Kristinn    | Leuchs      |
+-------------+-------------+
```

The 20 randomly selected tweets are obtained from the code in *tweets.py* and given as below.  

```
['Congrats Sindu Giri 👏\n#umsialumni https://t.co/O9vSib7beB', 1]
['Q3: How will the idea of traditional learning shift?', 0]
["HAPPENING NOW! Join us today for UMSI's QuasiCon 2018 a FREE annual gathering that brings information professionals… https://t.co/QOrqV7qBdG", 0]
['.@umsi professor @LionelPeterRob1 was featured on The Lynn Martin show discussing #automatedvehicles! Check it out… https://t.co/aCyDwc0LFj', 2]
['RT @christinacz: Tyree’s hacking the @Allied_Media site and showing us how #amc2018 #TC2018 https://t.co/uhxz6Ia3iR', 1]
['RT @Cs2019Our: This #OurCS2019 project applies user experience research, human-centered design, and interaction design to understand how sm…', 2]
['UMSI students showcase their research, display their projects, and participate in lightning talks about local and g… https://t.co/2I4nqOiEUv', 0]
['RT @Ismail_badache: ACM Table of Contents with all #SIGIR2018 papers is now online here.  \nhttps://t.co/vkqmFzT1g6\n(PDFs available July 8th…', 3]
['RT @gaycyborg: Myself and @_rnbrewer repping @umsi at the session on Making Core Memory lead by @SamShorey at #iConf19. Learning about hist…', 3]
['RT @drchuck: How I record my MOOC lectures (updated) - https://t.co/Gj7PwzmUqt', 1]
['📣 Today is the last day to register for the Fall 2019 Student Exposition 📣 https://t.co/yKse1F38UW https://t.co/nKjCs4nAYu', 0]
["Thanks! Can't wait for 2019 ✨ @igniteumxi https://t.co/054ZSrg98G", 0]
['UMSI senior Jessica Vu is studying UX and is spending her Alternative Spring Break in Detroit working at… https://t.co/FzxxGT7K0t', 1]
["Congrats to Sarita Schoenebeck on her recent promotion to associate professor with tenure 👏She's best known for her… https://t.co/DrLpYWiZPN", 1]
['RT @cab938: @houshuang @umsi @jpgard @las18ed And, the platform for replication we developed is completely open source on GitHub https://t.…', 4]
['.@UChicago assistant professor @saskatchewin looks at gender inequality in labor markets through a study of male an… https://t.co/p52iL6RTGi', 0]
['MSI student Desiree McLain is using information to remove sociotechnical barriers to entrepreneurship in #Detroit.… https://t.co/uBjdD8txrV', 0]
['RT @sdemonner: Anthony Whyte sharing his experience as a Lecturer for the @umsi SI 664 course this Fall with the ITS Teaching &amp; Learning te…', 5]
['RT @an_dre_a_: My awesome ta got me a document for Christmas ❤️ https://t.co/pt3ogiRzpt', 1]
['@uofmbec @UMengineering @UMich @michigan_AI @UMRobotics @UMichResearch 👏👏👏', 0]
```  

And for the last three questions,  
1) There will be ProgrammingError when there's something wrong in programming in MySQL. For instance, when using a table that is not found. DataError occurs when something goes wrong about data processing. For instance, when a number is divided by 0.  
2) Lists will be returned by **fetch all**.  
3) We should close the cursor with *.close()* on the cursor. And this is done in my code.

That's all of the results. And I hope they will help!

Best regards,
Xinhao Liao

--  
<span style="color:blue">Database query list</span>   
```
mysql> use ro_query;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> desc taxdata;
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| id       | int(11)      | NO   | PRI | NULL    | auto_increment |
| ein      | int(11)      | YES  |     | NULL    |                |
| name     | varchar(255) | YES  |     | NULL    |                |
| year     | int(11)      | YES  |     | NULL    |                |
| revenue  | bigint(20)   | YES  |     | NULL    |                |
| expenses | bigint(20)   | YES  |     | NULL    |                |
| purpose  | text         | YES  |     | NULL    |                |
| ptid     | varchar(255) | YES  |     | NULL    |                |
| ptname   | varchar(255) | YES  |     | NULL    |                |
| city     | varchar(255) | YES  |     | NULL    |                |
| state    | varchar(255) | YES  |     | NULL    |                |
| url      | varchar(255) | YES  |     | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
12 rows in set (0.03 sec)

mysql> select count(distinct ein) from taxdata where year = 2014 and city = 'Ann Arbor';
+---------------------+
| count(distinct ein) |
+---------------------+
|                 245 |
+---------------------+
1 row in set (0.46 sec)

mysql> select distinct name from taxdata where revenue > 10000000000 and year = 2014;
+---------------------------------------------------------------+
| name                                                          |
+---------------------------------------------------------------+
| IHC HEALTH SERVICES INC                                       |
| CENTRAL STATES SE & SW AREAS HEALTH & WELFARE F               |
| Banner Health                                                 |
| KAISER FOUNDATION HEALTH PLAN INC                             |
| Thrivent Financial for Lutherans                              |
| UAW RETIREE MEDICAL BENEFITS TRUST                            |
| KAISER FOUNDATION HOSPITALS                                   |
| Massachusetts Institute of Technology                         |
| UPMC GROUP                                                    |
| Cornell University                                            |
| Trustees of the University of Pennsylvania                    |
| President and Fellows of Harvard College                      |
| YALE UNIVERSITY                                               |
| STATE EMPLOYEES' CREDIT UNION                                 |
| DUKE UNIVERSITY                                               |
| Howard Hughes Medical Institute                               |
| Partners HealthCare System Inc & AffiliatesGroup Return       |
| THE BOARD OF TRUSTEES OF THE LELAND STANFORDJUNIOR UNIVERSITY |
| DIGNITY HEALTH                                                |
+---------------------------------------------------------------+
19 rows in set (1.12 sec)

mysql> select distinct name from taxdata where revenue > 10000000000;
ERROR 2006 (HY000): MySQL server has gone away
No connection. Trying to reconnect...
Connection id:    59
Current database: ro_query

+---------------------------------------------------------------+
| name                                                          |
+---------------------------------------------------------------+
| IHC HEALTH SERVICES INC                                       |
| CENTRAL STATES SE & SW AREAS HEALTH & WELFARE F               |
| KAISER FOUNDATION HEALTH PLAN INC                             |
| Banner Health                                                 |
| KAISER FOUNDATION HOSPITALS                                   |
| Thrivent Financial for Lutherans                              |
| UAW RETIREE MEDICAL BENEFITS TRUST                            |
| Massachusetts Institute of Technology                         |
| UPMC GROUP                                                    |
| Cornell University                                            |
| Trustees of the University of Pennsylvania                    |
| President and Fellows of Harvard College                      |
| YALE UNIVERSITY                                               |
| STATE EMPLOYEES' CREDIT UNION                                 |
| DUKE UNIVERSITY                                               |
| Howard Hughes Medical Institute                               |
| Partners HealthCare System Inc & AffiliatesGroup Return       |
| THE BOARD OF TRUSTEES OF THE LELAND STANFORDJUNIOR UNIVERSITY |
| WORKERS' COMPENSATION REINSURANCE ASSOCIATION                 |
| DIGNITY HEALTH                                                |
+---------------------------------------------------------------+
20 rows in set (0.68 sec)

mysql> select distinct name, expenses from taxdata where year = 2013 order by expenses desc limit 20;
+---------------------------------------------------------+-------------+
| name                                                    | expenses    |
+---------------------------------------------------------+-------------+
| KAISER FOUNDATION HEALTH PLAN INC                       | 41982288055 |
| UNIVERSITY OF ROCHESTER                                 |  2776536619 |
| ST FRANCIS HOSPITAL AND MEDICAL CENTER                  |   713077460 |
| WELLSTAR HEALTH SYSTEM INC                              |   660400156 |
| SKY LAKES MEDICAL CENTER                                |   488333644 |
| NAPLES COMMUNITY HOSPITAL INC                           |   426168844 |
| YAKIMA VALLEY MEMORIAL HOSPITAL                         |   401985865 |
| EMBRY-RIDDLE AERONAUTICAL UNIVERSITY INC                |   374154000 |
| ST MARY'S HOSPITAL & MEDICAL CENTERINC                  |   372041256 |
| St Barnabas Hospital                                    |   349321637 |
| HOSPITAL COMMITTEE FOR THE LIVERMOREPLEASANTON AREA     |   341257233 |
| VALLEY PRESBYTERIAN HOSPITAL                            |   273789797 |
| WINCHESTER HOSPITAL                                     |   264605951 |
| TEAMSTERS WESTERN REGION AND NEW JERSEYHEALTH CARE FUND |   231059337 |
| OROVILLE HOSPITAL                                       |   200242937 |
| ST JOSEPH HOSPITAL OF EUREKA                            |   196999313 |
| SWARTHMORE COLLEGE                                      |   168742729 |
| ST FRANCIS HOSPITAL - POUGHKEEPSIE                      |   164506124 |
| Vail Clinic Inc                                         |   159617575 |
| TUSKEGEE UNIVERSITY                                     |   152572824 |
+---------------------------------------------------------+-------------+
20 rows in set (0.34 sec)

mysql> select distinct name from taxdata where revenue > 1000000000;
+-----------------------------------------------------------------------------+
| name                                                                        |
+-----------------------------------------------------------------------------+
| PROVIDENCE HEALTH SYSTEM -SO CALIFORNIA                                     |
| SUTTER HEALTH SACRAMENTO SIERRA REGION                                      |
| Children's Healthcare of Atlanta Inc                                        |
| Healthfirst PHSP Inc                                                        |
| KALEIDA HEALTH                                                              |
| KAISER FOUNDATION HEALTH PLAN OF COLORADOINC                                |
| TEAMSTERS WESTERN REGION AND NEW JERSEYHEALTH CARE FUND                     |
| NATIONAL AUTOMATIC SPRINKLER INDUSTRY WELFARE FUND                          |
| IHC HEALTH SERVICES INC                                                     |
| Security Health Plan of Wisconsin Inc                                       |
| The Boeing Company Veba Master Trust                                        |
| AMERICAN POSTAL WORKERS UNION AFL CIO HEALTH                                |
| MAYO CLINIC HOSPITAL - ROCHESTER                                            |
| THE NEMOURS FOUNDATION                                                      |
| LONG ISLAND JEWISH MEDICAL CENTERC/O NORTH SHORE-LIJ HEALTH SYSTEM          |
| INDIANA UNIVERSITY HEALTH INC                                               |
| Santa Barbara Cottage Hospital                                              |
| MOTION PICTURE INDUSTRY HEALTH PLAN                                         |
| SSM Health Care St Louis                                                    |
| Atlantic Health System Inc Group Return                                     |
| CENTRAL STATES SE & SW AREAS HEALTH & WELFARE F                             |
| West Penn Allegheny Health System Inc                                       |
| METHODIST HOSPITAL GROUP                                                    |
| HACKENSACK UNIVERSITY MEDICAL CENTER                                        |
| BOY SCOUTS OF AMERICA                                                       |
| Charleston Area Medical Center Inc                                          |
| American Electric Power System EmployeesBenefit Trust                       |
| Miami Valley Hospital                                                       |
| PARK NICOLLET GROUP RETURN                                                  |
| MERITER HOSPITAL INC                                                        |
| SEVENTH-DAY ADVENTISTS LOMA LINDAUNIVERSITY MEDICAL CENTER                  |
| FRANCISCAN ALLIANCE INC                                                     |
| Aurora Health Care Inc Group Return                                         |
| FORSYTH MEMORIAL HOSPITAL                                                   |
| NOVANT HEALTH INC                                                           |
| Priority Health                                                             |
| The Cooper Health System a New JerseyNon-Profit Corporation                 |
| UNITED STEEL PAPER AND FORESTRYRUBBER MANUFACTURING ENERGY ALLIED           |
| UNITE HERE HEALTH                                                           |
| NATIONAL ELEVATOR INDUSTRY HEALTH BENEFIT PLAN                              |
| KAISER FOUNDATION HEALTH PLAN INC                                           |
| KNIGHTS OF COLUMBUS                                                         |
| BayCare Health System Inc                                                   |
| Palos Community Hospital                                                    |
| SCAN HEALTH PLAN                                                            |
| Banner Health                                                               |
| KAISER FOUNDATION HOSPITALS                                                 |
| MAYO FOUNDATION FOR MEDICAL EDUCATION AND RESEARCH                          |
| VNS CHOICE                                                                  |
| KAISER FOUNDATION HEALTH PLANOF THE NORTHWEST INC                           |
| HARVARD VANGUARD MEDICAL ASSOCIATES INC                                     |
| ALLINA HEALTH SYSTEM                                                        |
| SELECTHEALTH INC                                                            |
| Educational Testing Service                                                 |
| Thrivent Financial for Lutherans                                            |
| GROUP HEALTH COOPERATIVE                                                    |
| THE TOLEDO HOSPITAL                                                         |
| Nationwide Children's Hospital Group Return                                 |
| SENTARA HEALTHCARE                                                          |
| THE EVANGELICAL LUTHERAN GOOD SAMARITAN SOCIETY                             |
| MULTICARE HEALTH SYSTEM                                                     |
| KAISER FOUNDATION HEALTH PLAN OF THEMID-ATLANTIC STATES INC                 |
| FINANCIAL INDUSTRY REGULATORY AUTHORITY INC                                 |
| Ochsner Clinic Foundation                                                   |
| PRESBYTERIAN HEALTHCARE SERVICES                                            |
| KAISER FOUNDATION HEALTH PLAN OF GEORGIA INC                                |
| CAPITAL DISTRICT PHYSICIANS' HEALTH PLAN INC                                |
| METHODIST HEALTHCARE - MEMPHIS HOSPITALS                                    |
| KAISER FOUNDATION HEALTH PLAN OF GEORGIAINC                                 |
| Children's Medical Center of Dallas                                         |
| CENTRA HEALTH INC                                                           |
| OAKWOOD HEALTHCARE INC                                                      |
| GROUP HEALTH PLAN INC                                                       |
| Maimonides Medical Center                                                   |
| Memorial Sloan-Kettering Cancer Center                                      |
| PGA TOUR INC                                                                |
| American Bureau of Shipping                                                 |
| Children's Healthcare of Atlanta Group Return                               |
| SWEDISH HEALTH SERVICES                                                     |
| Virginia Mason Medical Center                                               |
| HEALTH SHARE OF OREGON                                                      |
| SUTTER EAST BAY HOSPITALS                                                   |
| SOUTHERN CALIFORNIA EDISON CO VEBA                                          |
| UAW RETIREE MEDICAL BENEFITS TRUST                                          |
| 1199SEIU NATIONAL BENEFIT FUND FORHEALTH AND HUMAN SERVICE EMPLOYEES        |
| Tufts Associated Health MaintenanceOrganization Inc                         |
| UNITED STATES STEEL CORPORATIONREPRESENTED RETIREES BENEFIT TRUST           |
| THE CLEVELAND CLINIC FOUNDATION                                             |
| MONTEFIORE MEDICAL CENTER                                                   |
| BETH ISRAEL MEDICAL CENTER                                                  |
| MANAGEMENT-ILA MANAGED HEALTHCARE TRUST FUND                                |
| Winthrop University Hospital Association                                    |
| BRAZOS ELECTRIC POWER COOPERATIVE INC                                       |
| St Elizabeth Medical Center Inc                                             |
| HEALTHPLUS OF MICHIGAN                                                      |
| STATEN ISLAND UNIVERSITY HOSPITAL                                           |
| PALO ALTO MEDICAL FOUNDATION                                                |
| PRESENCE HOSPITALS PRV                                                      |
| St George Corporation                                                       |
| JOHN MUIR HEALTH                                                            |
| FEEDING AMERICA                                                             |
| Summa Health Group Return                                                   |
| UNIVERSITY OF WISCONSIN FOUNDATION                                          |
| THE NEW YORK AND PRESBYTERIAN HOSPITAL                                      |
| WILLIAM BEAUMONT HOSPITAL                                                   |
| AFFINITY HEALTH PLAN INC                                                    |
| PROVIDENCE HEALTH & SERVICES - OREGON                                       |
| Children's Health Care                                                      |
| BLUE CARE NETWORK OF MICHIGAN                                               |
| GRADY MEMORIAL HOSPITAL CORPORATION                                         |
| CareSource                                                                  |
| THE MOUNT SINAI HOSPITAL                                                    |
| MVP HEALTH PLAN INC                                                         |
| KAISER FOUNDATION HEALTH PLANOF THE NORTHWEST                               |
| AMERICAN CHEMICAL SOCIETY                                                   |
| Aurora Health Care Inc                                                      |
| UNIVERSITY HEALTH SYSTEM INC                                                |
| HENRY FORD HEALTH SYSTEM                                                    |
| Wells Fargo & Co Employee Benefit Trust                                     |
| ROBERT WOOD JOHNSON UNIVERSITY HOSPITAL                                     |
| MEDICA HEALTH PLANS                                                         |
| THE CLEVELAND CLINIC FOUNDATION GROUP RETURN                                |
| GENERAL ELECTRIC INSURANCE PLAN TRUST                                       |
| COMMUNITY HEALTH PLAN OF WASHINGTON                                         |
| Lenox Hill HospitalC/O NORTH SHORE-LIJ HEALTH SYSTEM                        |
| Norton Hospitals Inc                                                        |
| THE METHODIST HOSPITAL                                                      |
| NORTH SHORE-LONG ISLAND JEWISH HEALTH CARE                                  |
| WAL-MART STORES INCASSOCIATES' HEALTH & WELFARE TRUST                       |
| ICAHN SCHOOL OF MEDICINE AT MOUNT SINAI                                     |
| GOVERNMENT EMPLOYEES HEALTH ASSOCIATION INC                                 |
| OPTIMA HEALTH PLAN                                                          |
| SOUTHEASTERN CONFERENCE                                                     |
| Fallon Community Health Plan Inc                                            |
| CITY UNIVERSITY CONSTRUCTION FUND                                           |
| NEIGHBORHOOD HEALTH PLAN INC                                                |
| YOUNG MEN'S CHRISTIAN ASSOCIATION RETIREMENT FUND                           |
| HEALTH ALLIANCE PLAN OF MICHIGAN                                            |
| University Hospitals Health System IncGroup Return                          |
| INTERNATIONAL BROTHERHOOD OF ELECTRICALWORKERS' PENSION BENEFIT FUND        |
| DELTA DENTAL OF CALIFORNIA                                                  |
| University Health Network                                                   |
| HEALTHPARTNERS INC                                                          |
| NEW YORK SOCIETY FOR THE RELIEF OF THERUPTURED AND CRIPPLED MAINTAINING THE |
| Managed Health Inc                                                          |
| THE RESEARCH FOUNDATION FOR THESTATE UNIVERSITY OF NEW YORK                 |
| JEWISH COMMUNAL FUND                                                        |
| TEXAS MUTUAL INSURANCE COMPANY                                              |
| MODERN WOODMEN OF AMERICA                                                   |
| MAYO CLINIC                                                                 |
| WESCOM CENTRAL CREDIT UNIONDBA WESCOM CREDIT UNION                          |
| PROVIDENCE HEALTH & SERVICES - WASHINGTON                                   |
| DELTA DENTAL PLAN OF MICHIGAN INC                                           |
| SUTTER HEALTH                                                               |
| INOVA HEALTH CARE SERVICES                                                  |
| SENTARA HOSPITALS                                                           |
| Adventist Health SystemSunbelt Inc                                          |
| Mercy Health                                                                |
| NATL CHRISTIAN CHARITABLE FDN INC                                           |
| Prairie Meadows Race Track and Casino Inc                                   |
| KAISER FOUNDATION HEALTH PLAN OF COLORADO                                   |
| Texas Health Resources                                                      |
| BJC HEALTH SYSTEM GROUP RETURN                                              |
| CONFERENCE ON JEWISH MATERIAL CLAIMSAGAINST GERMANY INC                     |
| SUTTER WEST BAY HOSPITALS                                                   |
| LINE CONSTRUCTION BENEFIT FUND                                              |
| INDEPENDENT HEALTH ASSOCIATION INC                                          |
| HARVARD PILGRIM HEALTH CARE INC                                             |
| MERIDIAN HEALTH SYSTEM INC - SUBORDINATES                                   |
| Riverside Healthcare Association Inc Group                                  |
| NORTH SHORE UNIVERSITY HOSPITALC/O NORTH SHORE-LIJ HEALTH SYSTEM            |
| Advocate Health And Hospitals Corp                                          |
| AMERICAN HEART ASSOCIATION INC                                              |
| Arizona State University Foundation For A NewAmerican University            |
| Albany Medical Center Group Organization                                    |
| UNITED FOOD & COMMERCIAL WORKERS UNIONS& FOOD EMPLOYERS BENEFIT FUND        |
| UNIVERSITY OF TORONTO                                                       |
| SILICON VALLEY COMMUNITY FOUNDATION                                         |
| ST VINCENT HOSPITAL AND HEALTH CARE CENTER INC                              |
| The Rotary Foundation of Rotary International                               |
| DePaul University                                                           |
| World Vision Inc                                                            |
| OhioHealth Corporation Group Return                                         |
| THE CHANCELLOR MASTER AND SCHOLARSOF THE UNIVERSITY OF CAMBRIDGE            |
| ST LUKE'S-ROOSEVELT HOSPITAL CENTER                                         |
| NATIONAL RURAL UTILITIES COOPERATIVEFINANCE CORPORATION                     |
| COMMUNITY FOUNDATION OF NORTHWEST INDIANAINC                                |
| NORTH CAROLINA BAPTIST HOSPITAL                                             |
| HAWAI'I PACIFIC HEALTH GROUP RETURN                                         |
| SCHWAB CHARITABLE FUND                                                      |
| METROPOLITAN MUSEUM OF ART                                                  |
| CARNEGIE MELLON UNIVERSITY                                                  |
| Massachusetts Institute of Technology                                       |
| UPMC GROUP                                                                  |
| THE MEDSTAR-GEORGETOWN MEDICAL CENTER INC                                   |
| DUKE UNIVERSITY HEALTH SYSTEM INC                                           |
| CAMPBELL UNIVERSITY INC                                                     |
| THE NEW SCHOOL                                                              |
| CHILDREN'S HOSPITAL LOS ANGELES                                             |
| THE CHILDREN'S HOSPITAL OF PHILADELPHIA                                     |
| YORK HOSPITAL                                                               |
| William Marsh Rice University                                               |
| TRUSTEES OF BOSTON UNIVERSITY                                               |
| BILLINGS CLINIC                                                             |
| HARVARD PRIVATE CAPITAL REALTY INCC/O HARVARD MANAGEMENT COMPANY INC        |
| UNIVERSITY OF DAYTON                                                        |
| SYRACUSE UNIVERSITY                                                         |
| PEACEHEALTH                                                                 |
| NORTHSIDE HOSPITAL INC                                                      |
| CHRISTIANA CARE HEALTH SERVICES INC                                         |
| COMMUNICATIONS WORKERS OF AMERICA AFL-CIO CLC                               |
| Our Lady of the Lake Hospital Inc                                           |
| Cornell University                                                          |
| The Chancellor Master & Scholars of the University of Oxford                |
| LIBERTY UNIVERSITY INC                                                      |
| NATIONAL ASSOCIATION OF LETTER CARRIERS                                     |
| COLORADO SEMINARY                                                           |
| TEXAS CHRISTIAN UNIVERSITY                                                  |
| UNIVERSITY OF ROCHESTER                                                     |
| Indiana University Foundation                                               |
| American National Red Cross & Its ConstituentChapters and Branches          |
| PENNSYLVANIA EMPLOYEES BENEFIT TRUST FUND                                   |
| THE COMMON FUND FOR NONPROFIT ORGANIZATIONS                                 |
| Trustees of the University of Pennsylvania                                  |
| Lancaster General Hospital                                                  |
| LEHIGH UNIVERSITY                                                           |
| WILLIS-KNIGHTON MEDICAL CENTER                                              |
| The Queen's Medical Center                                                  |
| TRUSTEES OF BOSTON COLLEGE                                                  |
| President and Fellows of Harvard College                                    |
| YALE UNIVERSITY                                                             |
| PARTNERSHIP FOR SUPPLY CHAIN MANAGEMENT                                     |
| FROEDTERT HEALTH INC                                                        |
| UNIVERSITY OF CHICAGO                                                       |
| NATURE CONSERVANCY                                                          |
| SOUTHERN METHODIST UNIVERSITY                                               |
| THE ROCKEFELLER UNIVERSITY                                                  |
| SWARTHMORE COLLEGE                                                          |
| AMERICAN LEBANESE SYRIAN ASSOCIATED CHARITIES INC                           |
| Vanderbilt University                                                       |
| University of Chicago Medical Ctr                                           |
| Scott & White Memorial Hospital                                             |
| Christus Health                                                             |
| LOYOLA UNIVERSITY MEDICAL CENTER                                            |
| Lehigh Valley Hospital                                                      |
| The Nebraska Medical Center                                                 |
| The Trustees of Princeton University                                        |
| SAINT LOUIS UNIVERSITY                                                      |
| GEISINGER HEALTH PLAN                                                       |
| Baylor College of Medicine                                                  |
| Sanford Group Return                                                        |
| Ascension Health Alliance                                                   |
| UNIVERSITY OF PITTSBURGH                                                    |
| POMONA COLLEGE                                                              |
| GEORGETOWN UNIVERSITY                                                       |
| THE TRUSTEES OF COLUMBIA UNIVERSITYIN THE CITY OF NEW YORK                  |
| The George Washington University                                            |
| Michigan Catastrophic Claims Association                                    |
| CEDARS-SINAI MEDICAL CENTER                                                 |
| University of Southern California                                           |
| FROEDTERT MEMORIAL LUTHERAN HOSPITAL INC                                    |
| ALBERT EINSTEIN HEALTHCARE NETWORK GROUPLETTER RULING                       |
| Mary Hitchcock Memorial Hospital                                            |
| GEISINGER MEDICAL CENTER                                                    |
| HARVARD MANAGEMENT PRIVATE EQUITY CORPC/O HARVARD MANAGEMENT COMPANY INC    |
| MILTON HERSHEY SCHOOL AND SCHOOL TRUST                                      |
| STATE EMPLOYEES' CREDIT UNION                                               |
| Fordham University                                                          |
| Trustees for Harvard University                                             |
| UC Healthcare System                                                        |
| WASHINGTON HOSPITAL CENTER CORPORATION                                      |
| The Children's Mercy Hospital                                               |
| Memorial Hermann Health System                                              |
| Catholic Health Initiatives                                                 |
| CHI St Luke's Health Baylor College of Medicine Medical Center              |
| LOMA LINDA UNIVERSITY                                                       |
| DUKE UNIVERSITY                                                             |
| SHANDS TEACHING HOSPITAL AND CLINICS INC                                    |
| Brown University                                                            |
| NORTHEASTERN UNIVERSITY                                                     |
| Rush University Medical Center                                              |
| Catholic Health Initiatives Colorado                                        |
| MOUNT CARMEL HEALTH SYSTEM                                                  |
| The Medical College of Wisconsin Inc                                        |
| UPMC                                                                        |
| UNIVERSITY OF MARYLAND MEDICAL SYSTEM CORP                                  |
| Temple University Hospital Inc                                              |
| YESHIVA UNIVERSITY                                                          |
| THE UNIVERSITY OF WESTERN ONTARIO                                           |
| THE ADMINISTRATORS OF THE TULANE EDUCATIONAL FUND                           |
| Edward Hospital                                                             |
| PINNACLE HEALTH HOSPITALS                                                   |
| Spectrum Health System Group Return                                         |
| Children's Hospital                                                         |
| Baylor University Medical Center                                            |
| Children's Hospital Medical Center                                          |
| NATIONAL PHILANTHROPIC TRUST                                                |
| JOHNS HOPKINS UNIVERSITY                                                    |
| THE CHILDREN'S HOSPITAL OF PHILADELPHIAFOUNDATION                           |
| MERCY HOSPITALS EAST COMMUNITIES                                            |
| University of Miami                                                         |
| Main Line Hospitals Inc                                                     |
| OhioHealth Corporation                                                      |
| TRINITY HEALTH CORPORATION                                                  |
| Franciscan Health System                                                    |
| AMERICAN BIBLE SOCIETY                                                      |
| DREXEL UNIVERSITY                                                           |
| University of Notre Dame du Lac                                             |
| TRUSTEES OF THE ESTATE OF BERNICE PAUAHIBISHOP                              |
| CALIFORNIA ACADEMY OF SCIENCES                                              |
| CASE WESTERN RESERVE UNIVERSITY                                             |
| MEMORIAL HEALTH SERVICES GROUP RETURN                                       |
| TRINITY HEALTH - MICHIGAN                                                   |
| THE JOHNS HOPKINS HOSPITAL                                                  |
| Trustees of Dartmouth College                                               |
| University of Delaware                                                      |
| Saint Francis Hospital Inc                                                  |
| Temple University - Of the Commonwealth System of Higher Education          |
| BUILDING SERVICE 32BJ HEALTH FUND                                           |
| WASHINGTON UNIVERSITY                                                       |
| NORTH CAROLINA ELECTRIC MEMBERSHIPCORPORATION                               |
| GLOBAL HEALTH SOLUTIONS INC                                                 |
| HOAG MEMORIAL HOSPITAL PRESBYTERIAN                                         |
| MICHIGAN EDUCATION SPECIAL SERVICES ASSN                                    |
| Trustees of Tufts College                                                   |
| THE HOWARD UNIVERSITY                                                       |
| Mercy Hospital Springfield                                                  |
| DELTA PILOTS DISABILITY AND SURVIVOR TRUST                                  |
| Howard Hughes Medical Institute                                             |
| Food For the Poor Inc                                                       |
| PORTERCARE ADVENTIST HEALTH SYSTEM                                          |
| Patient Access Network Foundation                                           |
| REX HOSPITAL INC                                                            |
| City of Hope National Medical Center                                        |
| Marshfield Clinic Inc                                                       |
| MOSES H CONE MEMORIAL HOSPITALOPERATING CORPORATION                         |
| Rhode Island Hospital                                                       |
| BOSTON MEDICAL CENTER                                                       |
| NorthShore University HealthSystem                                          |
| Orlando Health Inc                                                          |
| North Mississippi Medical Center Inc                                        |
| THE MITRE CORPORATION                                                       |
| CUMBERLAND COUNTY HOSPITAL SYSTEM INC                                       |
| PALMETTO HEALTH                                                             |
| CARILION MEDICAL CENTER                                                     |
| Partners HealthCare System Inc & AffiliatesGroup Return                     |
| Hartford Hospital                                                           |
| OSF HEALTHCARE SYSTEM                                                       |
| WakeMed                                                                     |
| NYU HOSPITALS CENTER                                                        |
| ASANTE                                                                      |
| BETH ISRAEL DEACONESS MEDICAL CENTER                                        |
| Children's Hospital Corporation                                             |
| CENTRAL ELECTRIC POWER COOPERATIVE INC                                      |
| Northwestern Memorial HealthCare                                            |
| STANFORD HEALTH CARE                                                        |
| Baptist Healthcare System Inc                                               |
| FLORIDA HEALTH SCIENCES CENTER INC                                          |
| NEW YORK UNIVERSITY                                                         |
| FRESNO COMMUNITY HOSPITAL AND MEDICAL CENTER                                |
| Ann & Robert H Lurie Childrens Hospital ofChicago                           |
| Northwestern University                                                     |
| METROPLUS HEALTH PLAN INC                                                   |
| Northwestern Memorial Healthcare Group                                      |
| SHRINERS HOSPITALS FOR CHILDREN                                             |
| Lucile Salter Packard Children'sHospital at Stanford                        |
| THE BOARD OF TRUSTEES OF THE LELAND STANFORDJUNIOR UNIVERSITY               |
| BAPTIST HOSPITAL OF MIAMI INC                                               |
| Baystate Medical Center Inc                                                 |
| Pitt County Memorial Hospital Inc                                           |
| Sharp Memorial Hospital                                                     |
| GUARANTY ASSOCIATION BENEFITS COMPANY                                       |
| UMASS MEMORIAL HEALTH CARE INC & AFFILIATES                                 |
| BATTELLE MEMORIAL INSTITUTE                                                 |
| Eastern Maine Healthcare Systems EMMCEastern Maine Medical Center           |
| METHODIST HOSPITALS OF DALLAS &PAVILION PROPERTIES                          |
| Dana-Farber Cancer Institute Inc                                            |
| California Institute of Technology                                          |
| WEA INSURANCE CORPORATION                                                   |
| WORKERS' COMPENSATION REINSURANCE ASSOCIATION                               |
| NEW YORK STATE CATHOLIC HEALTH PLANINC                                      |
| LESTER E COX MEDICAL CENTERS                                                |
| Smithsonian Institution                                                     |
| MAINE MEDICAL CENTER                                                        |
| UNITED STUDENT AID FUNDS INC                                                |
| Delta Dental of Washington                                                  |
| BAPTIST HEALTH SOUTH FLORIDAINC                                             |
| EMORY GROUP RETURN                                                          |
| CYSTIC FIBROSIS FOUNDATION- HEADQUARTERS                                    |
| MEMORIAL HEALTH SYSTEM GROUP                                                |
| NATIONAL COLLEGIATE ATHLETIC ASSOCIATION                                    |
| EMORY UNIVERSITY                                                            |
| Scripps Health                                                              |
| THE UNIVERSITY OF VERMONT MEDICAL CENTER INC                                |
| MCLEOD REGIONAL MEDICAL CENTER OFTHE PEE DEE INC                            |
| YALE-NEW HAVEN HOSPITAL                                                     |
| BOSTON MEDICAL CENTER HEALTH PLAN INC                                       |
| SEATTLE CHILDREN'S HOSPITAL                                                 |
| UCare Minnesota                                                             |
| DIGNITY HEALTH                                                              |
| RADY CHILDREN'S HOSPITAL - SAN DIEGO                                        |
| Southern Baptist Hospital of Florida Inc                                    |
| Sharp HealthCare                                                            |
| St Luke's Regional Medical Center                                           |
+-----------------------------------------------------------------------------+
404 rows in set (0.31 sec)

mysql> select count(distinct ein) from taxdata where purpose LIKE "% toy %" or purpose LIKE "% toys %" or purpose LIKE "% toy. %" or  purpose LIKE "% toys. %" or purpose LIKE "toy %" or purpose LIKE "toys %" or purpose LIKE "% toy." or  purpose LIKE "% toys.";
+---------------------+
| count(distinct ein) |
+---------------------+
|                 261 |
+---------------------+
1 row in set (7.07 sec)

mysql> select count(1) from taxdata where ptname LIKE "%smith%" and revenue IS NOT NULL and revenue != 0;
+----------+
| count(1) |
+----------+
|     2796 |
+----------+
1 row in set (0.44 sec)

mysql> select distinct name, LENGTH(name) as 'length of name' from taxdata where ptid = 'P01345770' order by rand() limit 50;
+-----------------------------------------------------+----------------+
| name                                                | length of name |
+-----------------------------------------------------+----------------+
| The Rivera Krall Family Foundation                  |             34 |
| The Kao Family Foundation                           |             25 |
| Dixon and Carol Doll Family Foundation              |             38 |
| The Joyce Family Foundation                         |             27 |
| The Burt's Bees Greater Good Foundation             |             39 |
| The Watts Family Foundation                         |             27 |
| Witman Family Foundation                            |             24 |
| The Bess Family Foundation                          |             26 |
| BunnyJack Gives Foundation                          |             26 |
| YDFW Inc                                            |              8 |
| The Caine Family Foundation                         |             27 |
| The El-Erian Family Foundation                      |             30 |
| The Hill Family Charitable Foundation               |             37 |
| Spillers Family Foundation                          |             26 |
| The Migdol Family Foundation Inc                    |             32 |
| The SlimGenics Foundation                           |             25 |
| The Regeneration Foundation                         |             27 |
| Weseley Family Charitable Foundation                |             36 |
| The Surplus Line Association of ArizonaFoundation   |             49 |
| The Foreside Foundation                             |             23 |
| John and Diane Scelfo Charitable Foundation         |             43 |
| The 3 Dimensional Wealth Foundation                 |             35 |
| Monasse Foundation                                  |             18 |
| Barbetta Family Foundation                          |             26 |
| The Wayland E Noland Foundation                     |             31 |
| NewCity Foundation                                  |             18 |
| McKiernan Family Foundation                         |             27 |
| Tom Russell Charitable Foundation Inc               |             37 |
| Chauncey Foundation                                 |             19 |
| William H Wood Family Foundation                    |             32 |
| The Trailviews Foundation                           |             25 |
| The Taking Flight Foundation                        |             28 |
| Gobioff Foundation                                  |             18 |
| Yad Ozer Foundation                                 |             19 |
| Plumeria Family Foundation                          |             26 |
| Flora & Doris Denova Foundation                     |             31 |
| Brigham Family Foundation                           |             25 |
| Trebek Family Foundation                            |             24 |
| The Anne R Monroe Foundation                        |             28 |
| The KL Holbrook Serendipitous Foundation            |             40 |
| AFNOVA Inc                                          |             10 |
| The Loftus Family Foundation                        |             28 |
| William Newkirk and Cheryl Tschanz FamilyFoundation |             51 |
| The King-Guffey Family Foundation                   |             33 |
| Burg Family Foundation                              |             22 |
| Start It Foundation                                 |             19 |
| Bill and Faye Stallings Family Foundation           |             41 |
| The Peter and Michelle Detkin FamilyFoundation      |             46 |
| D&P Roberts Family Foundation                       |             29 |
| The Mark E Pollack Foundation                       |             29 |
+-----------------------------------------------------+----------------+
50 rows in set (0.36 sec)

mysql> select count(distinct ein) from taxdata where purpose IS NOT NULL and LENGTH(purpose)<10;
+---------------------+
| count(distinct ein) |
+---------------------+
|               51548 |
+---------------------+
1 row in set (0.47 sec)

mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| ro_company1        |
| ro_employees       |
| ro_query           |
| ro_recipes         |
| ro_research1       |
| ro_twitter         |
| sys                |
+--------------------+
10 rows in set (0.05 sec)

mysql> use ro_employees;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+------------------------+
| Tables_in_ro_employees |
+------------------------+
| departments            |
| dept_emp               |
| dept_manager           |
| employees              |
| salaries               |
| titles                 |
+------------------------+
6 rows in set (0.03 sec)

mysql> desc employees;
+------------+---------------+------+-----+---------+-------+
| Field      | Type          | Null | Key | Default | Extra |
+------------+---------------+------+-----+---------+-------+
| emp_no     | int(11)       | NO   | PRI | NULL    |       |
| birth_date | date          | NO   |     | NULL    |       |
| first_name | varchar(14)   | NO   |     | NULL    |       |
| last_name  | varchar(16)   | NO   |     | NULL    |       |
| gender     | enum('M','F') | NO   |     | NULL    |       |
| hire_date  | date          | NO   |     | NULL    |       |
+------------+---------------+------+-----+---------+-------+
6 rows in set (0.03 sec)

mysql> select * from employees limit 1;
+--------+------------+------------+-----------+--------+------------+
| emp_no | birth_date | first_name | last_name | gender | hire_date  |
+--------+------------+------------+-----------+--------+------------+
|  10001 | 1953-09-02 | Georgi     | Facello   | M      | 1986-06-26 |
+--------+------------+------------+-----------+--------+------------+
1 row in set (0.05 sec)

mysql> select count(1) from employees where year(hire_date) in (1994,1995,1990);
+----------+
| count(1) |
+----------+
|    52560 |
+----------+
1 row in set (0.46 sec)

mysql> desc titles;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| emp_no    | int(11)     | NO   | PRI | NULL    |       |
| title     | varchar(50) | NO   | PRI | NULL    |       |
| from_date | date        | NO   | PRI | NULL    |       |
| to_date   | date        | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
4 rows in set (0.03 sec)

mysql> select * from titles limit 1;
+--------+-----------------+------------+------------+
| emp_no | title           | from_date  | to_date    |
+--------+-----------------+------------+------------+
|  10001 | Senior Engineer | 1986-06-26 | 9999-01-01 |
+--------+-----------------+------------+------------+
1 row in set (0.03 sec)

mysql> select count(1) from titles where title = 'Senior Engineer' and from_date <= '1986-06-26' and to_date >= '1986-06-26';
+----------+
| count(1) |
+----------+
|     2795 |
+----------+
1 row in set (0.72 sec)

mysql> select distinct first_name, last_name from employees where emp_no in (select distinct emp_no from titles where title = 'Engineer');
^C^C -- query aborted
+----------------+------------------+
| first_name     | last_name        |
+----------------+------------------+
+----------------+------------------+
111930 rows in set (1.31 sec)

mysql> select distinct first_name, last_name from employees where emp_no in (select distinct emp_no from titles where title = 'Engineer') order by rand() limit 50;
+-------------+-------------+
| first_name  | last_name   |
+-------------+-------------+
| Xianlong    | Perng       |
| Frazer      | Kitsuregawa |
| Akemi       | Prampolini  |
| Quingbo     | Alblas      |
| LiMin       | Crouzet     |
| Toong       | Feinberg    |
| Girolamo    | Heering     |
| Gadiel      | Karlin      |
| Goo         | Shigei      |
| Godehard    | Merkl       |
| Georg       | Pollock     |
| Danel       | Rodite      |
| Kazuhide    | Kowalchuk   |
| Dipayan     | Kugler      |
| Zhensheng   | Hiyoshi     |
| Shay        | Delaune     |
| Chiranjit   | Velardi     |
| Almudena    | Comte       |
| Moni        | Trelles     |
| Krister     | Brendel     |
| Bouchung    | Adachi      |
| Cullen      | Kopetz      |
| Rasikan     | Veevers     |
| Golgen      | Lally       |
| Bartek      | Honglei     |
| Aris        | Legleitner  |
| Takahiro    | Murthy      |
| True        | Capobianchi |
| Constantino | Liesche     |
| Ranga       | Baak        |
| Jacopo      | Erie        |
| Moie        | Danner      |
| Trygve      | Wegerle     |
| Elvis       | Pusterhofer |
| Debatosh    | Ernst       |
| Brewster    | Schaad      |
| Mana        | Griswold    |
| Kendra      | Scharstein  |
| Dmitri      | Stavenow    |
| Hercules    | Maliniak    |
| Dulce       | Kisuki      |
| Shietung    | Skafidas    |
| Sajjad      | Ramaiah     |
| Thanasis    | Percebois   |
| Baziley     | Oxenboll    |
| Sanjiv      | Dredge      |
| Jiang       | Emmerich    |
| Florina     | Potthoff    |
| Saeko       | Wendorf     |
| Kristinn    | Leuchs      |
+-------------+-------------+
50 rows in set (0.76 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| ro_company1        |
| ro_employees       |
| ro_query           |
| ro_recipes         |
| ro_research1       |
| ro_twitter         |
| sys                |
+--------------------+
10 rows in set (0.03 sec)

mysql> use ro_twitter;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
mysql> show tables;
+----------------------+
| Tables_in_ro_twitter |
+----------------------+
| tweets               |
+----------------------+
1 row in set (0.02 sec)

mysql> desc tweets;
+-------+------------+------+-----+---------+-------+
| Field | Type       | Null | Key | Default | Extra |
+-------+------------+------+-----+---------+-------+
| id    | bigint(20) | NO   | PRI | NULL    |       |
| tweet | longtext   | YES  |     | NULL    |       |
+-------+------------+------+-----+---------+-------+
2 rows in set (0.02 sec)
```
