/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.math4.rng.internal.source32;

import org.junit.Assert;
import org.junit.Test;

public class Well19937aTest {
    @Test
    public void testReferenceCode() {
        final int[] base = {
            740849862,  1202665156,  -199039369,  -259008301,  -291878969, -1164428990, -1565918811,   491009864,
            -1883086670,  1383450241,  1244617256,   689006653, -1576746370, -1307940314,  1421489086,  1742094000,
            -595495729,  1047766204,  1875773301, -1637793284,  1379017098,   262792705,   191880010,  -251000180,
            -1753047622,  -972355720,    90626881,  1644693418,  1503365577,   439653419,  1806361562,  1268823869
        };
        final int[] init = new int[624];
        for (int i = 0; i < init.length; ++i) {
            init[i] = base[i % base.length] + i;
        }

        final Well19937a rng = new Well19937a(init);

        final int[] refInt = {
            -612874471,   -354976292,  -1838197125,  -1781560577,    278390997,   1214938280,  -1752615390,   -760835246,  -1712883765,   -241205782,   -145390202,    495649160,   -514388259,  -1271015916,  -1640000013,    849273623,
            -549729394,  -1206917255,   -545909692,    811925434,  -1665729633,  -1525292882,   1416246482,   -153220826,   1148868872,   -326143196,   1724979062,   1790931148,  -1648679618,   -439051683,    112482777,  -1484051520,
            -1881272572,  -1270447031,  -1216102401,   1579107248,  -1224395621,   2144411988,   -416216641,  -1529222361,   1628987080,    164445245,   1506928916,    928145916,   1436000427,    862025970,    560077705,  -1887251027,
            -514360858,   1735094506,    475624879,   1755802355,    295448361,   -155399225,      3972415,   1368201076,   -465126094,  -1622687259,   -246099304,   1798631152,  -1937269102,  -1700560396,   -293352622,   -896632303,
            -2088933220,   -194382452,   -480218162,  -1618517785,  -1925031481,   -150217434,   1678937261,   2130832364,   -485546678,  -1499224981,   1430390884,  -1895417302,    210514746,   1781140999,  -1940853105,  -1238099647,
            485922557,   -103223212,    633481679,   -632946979,    695235541,  -1661735272,    277603567,   -958341538,    256982285,   1850270018,   -327388076,   -219053874,   1380560653,  -1221689980,   1335863752,   -545032383,
            -575291735,  -1295623907,   -140058298,   1063302709,  -1290702617,   -790401546,   -170630961,  -1203114473,   1458063108,  -1212753301,   1546428514,   2112636413,  -1463028928,  -1812598032,   -883529486,   1131084094,
            62042165,   2135819802,  -1192342739,     98361522,  -1341042205,   -475283063,  -1632033747,   1745196892,    168608689,   -914987039,    274428907,   -881357258,    167940012,  -1975737532,   -903960486,  -1370984244,
            -589352935,   1783633514,   -570111010,     71495377,    194463285,  -1243905021,  -1398490898,    221691209,    -55728834,   -638916786,   -770622372,  -1911651810,   -295233027,    301467998,   2058638784,    681490183,
            -1547865078,  -1668135684,   1299261826,   1649468635,    287995017,  -2076844852,   1193468826,   -853948258,    120082777,   1051829542,  -1288514343,   -159456430,    275748820,   -480127107,   -604943233,  -2138088332,
            1202614819,   1427201263,  -1906344469,  -1230779533,   1690367192,    733159097,    794410312,  -1114452505,  -1601554413,    976747949,   1517787154,   2091780205,   1052078906,   1919282771,   -191013374,   1805397142,
            736939268,  -1056272823,   -727464316,   -659459005,    797803875,  -1104633884,   1042342081,    -24514837,   1919469940,   1903722546,   -814157872,   1605407665,   -262351256,   -288949635,    729204844,  -1132605534,
            745453338,    387915035,   1094173337,   2100279147,    156863702,   -257377544,   -719587984,  -1496015613,   1908993744,   2016957554,    918749666,   -135963651,  -1356808639,  -1711185741,   1472589240,   -398100149,
            628791415,  -1381837652,  -1820702771,   -593586943,  -1456631279,  -1837975351,  -1394249972,   -556916726,    833231177,     43449750,   1029237092,  -2086437337,   -459463076,   -533031784,  -1739648287,  -1374722961,
            2024908394,   1389678488,      2018558,  -1391707864,   -795935743,    904816957,    836583280,   1766194531,  -1374431014,   -904437876,   2030248636,   -265724199,   2056758426,   -810499837,    887193593,    -77811488,
            1496312336,  -1874348275,   -456193866,  -2137130942,    868120387,     29025455,  -1999867716,   2001322335,   -579152815,   -390892056,   1592011837,   -306394879,     93636886,   -190879994,   1923358153,    269052141,
            -396050253,   -987531729,    480350991,   1276744541,  -1445571957,   -957571005,  -2046270221,  -1715395752,   1113585628,  -1782113514,   -697560146,    835320000,   1014320959,  -2119834109,    460056841,  -1464772991,
            -1282790418,  -2120806165,     86176097,   -731086307,    832497517,  -1876684928,    541008240,    551124479,   -450919132,    647860281,  -2115397586,    979247589,   1095559204,   1927958688,    169497703,   1999579054,
            2019745038,   1656022059,  -1109662138,    375237154,   1450814436,    919988416,    849761266,   1457057327,   1771166577,  -1639880487,   -852488298,   1767063646,    657295386,   -585561879,    740792583,   1664558308,
            -654749506,   1109275990,    182597559,   1106789745,  -1806628480,     25948116,   1748374299,    196057325,   -164213209,   1687024594,    782029276,   1879737947,  -1528219611,    412585737,   1190325629,   1985821911,
            -1272945202,  -1238637137,    465818730,  -1537670961,   1131953615,    905623579,    609183424,   1138422991,   1522974699,    589719061,  -1310894604,    890952933,   -885204790,   -393535694,   1238408670,   1780660354,
            677803525,  -1121509064,   1553148616,   1109165936,  -1450120385,   1525252521,  -1354897489,   -595402189,  -1274551767,   -869281409,   1788815975,   2020262116,   1124100185,   -400839020,    310574108,   1354413045,
            -1310514485,   1895732085,    626639054,   1667355357,   2065637178,  -1889009143,   -440157749,   1762849463,  -1693853642,    -56602956,   -930874188,   -398470740,    778356402,  -2113156881,     42854964,   1844399604,
            -2098310302,  -1812029757,   1441188713,    899579267,   1266994172,   1841370863,   -660740252,    -43254718,   1124500192,   1884907320,    879997211,   1775139845,  -1360112721,   1630490057,    362567879,   1113475029,
            290319279,  -1209506867,    398146039,   -957742350,   1185761854,   1519676447,   -912689915,  -1117128973,   -305563462,  -1928033363,  -1766324543,   1702753492,   1696951912,  -1895072395,    932663591,   -566548128,
            991675996,     56529814,    980735023,    718166662,   -650028466,   -886842051,   1857048587,   -569023569,  -1820572202,   -851452711,   -958700452,   -621825633,    -65649888,   -510143183,    761267599,  -1692108035,
            1729071710,   1623630864,    -53498654,    267235687,    659201413,   1152882627,   -824194574,    356636960,   -502391121,   -538453360,     66115376,  -1633290370,  -1522088932,    268949070,    684499443,   -859474501,
            1586764345,  -1515639709,    319695602,   -307025150,     69076508,   1050726785,  -1340930110,    552191600,   -207852941,   -273572993,   -539580440,    710343120,   1957076127,  -1107172811,   -561518280,  -1775022699,
            1978792904,   1935531451,  -2084046304,   -419742902,   -737652926,    614022023,   1676952428,    769892939,  -1092786807,  -1117113223,   -266029995,   -350150999,    207738542,   1964896575,     48805284,   1736500159,
            551289617,  -1847923501,   1856609505,   2007480480,   -681860219,  -1198106493,   1483591043,   -523895316,  -1814473078,  -1521087404,  -1348859926,   1298056897,   1813789478,    946683654,     79196400,   1766250931,
            472737685,   1764634332,  -1844726079,   -130619045,   -508713868,  -1762537125,   1010108863,    170107098,   1705386380,  -1139681802,    183739097,   1662699401,   1842694501,   1714633805,     46208876,    616720693,
            -252553427,   1986302230,   -103130254,   1943225981,    110746655,    553260552,   1588938073,  -1934623163,  -2144781332,  -2086217416,   1941265852,   -781953226,   1216234254,    605543697,   -710872598,   2048636577,
            -1986927728,  -1007017623,   1243051501,   -614249563,  -2128221291,    581579813,   1173464240,  -1906830937,    261329601,  -1805974103,    769823490,   1858731164,   -561762071,    516417430,  -1221329437,   -825500715,
            1091364656,   -993658663,  -1475434188,  -1070804384,  -1876492082,    899494424,    683486936,    878807455,     56642807,  -1268202879,   1379172046,  -1386869373,  -1158233876,   1759190552,   1597629789,   1411151497,
            -1254268471,   1075936979,   -918778269,  -2132675184,    953140888,   1906982077,   1154200766,   -365384600,  -1142488826,    708535121,  -2134869964,  -1531201665,  -2100526761,   1268256467,   2071480803,    193135243,
            1374158182,    989505347,   -933612202,  -2134839213,  -1302795271,  -2092029041,   1812014826,   2090855917,   2005348528,    606434393,    -60141386,     11156360,    539516285,   -122485034,   -893237911,   -978127424,
            1509901816,   -451029719,    428544700,  -1622965963,  -1993611605,  -1989324583,   1104111587,   -795138585,   -899552401,  -2110167769,   -234502445,   1586963605,   -503778455,    529261062,    325327284,   -106186403,
            65369563,  -1475700698,   -228624261,    715975009,   1099352363,  -1796883396,   1376542700,   -308942420,   -344940451,   -395389249,  -1562737166,   1869802677,   1273494710,   2075587668,   -789570273,   1563347596,
            1142901755,   1676422422,  -1729157809,  -1399423717,  -1814262429,  -1809707284,   1393992342,   -570246212,   1065528749,   -781643849,   1218667301,  -1097949471,   1305629790,    901301039,   -704762030,    360582612,
            1411910672,   1848068741,   -614500891,   -146889637,   -913903597,    723527277,   -147033328,   -199273155,    734997691,  -2072735286,   2129258691,  -1385074104,    931616624,   1065477319,  -1543474555,   -531410292,
            -2123119121,  -1538464113,  -1153585193,   1559931968,   -654877011,    879865200,   1489681397,   1998864644,  -1964160144,    163671782,   -858364148,   -323324233,    801208648,    705864113,    436184243,    643773864,
            2087594507,    134637265,   -749956494,  -1657343972,  -1828172168,    -27357303,  -1145161336,  -1192513644,    216148260,    611393153,    -13752671,   -358631090,  -1211920749,    593572064,    657629904,  -1445961088,
            -250704995,   1797542707,  -2122311891,   -316774825,   -296303057,   -868002056,    -86697533,   2020588145,   1203427903,  -1371839056,    669531557,  -2031033836,   1323994690,     13703036,    785437772,  -1465821554,
            -694756014,  -2131068154,  -1745448876,  -1095891733,    936594025,  -1119068454,    855423970,   1705079340,   -905640608,    162297141,   1336619311,   -344353769,    -92608588,  -1080573824,   2002293105,  -2088030765,
            -1684198727,   -129054718,   -949437132,   -127983221,   -216664110,   1700146143,   -711174649,   1500113839,   1212236226,  -2017364219,  -1263597675,    511929344,   -323998524,  -2021313185,   1803000924,    927670608,
            336267187,   1244256964,  -1665390108,    991395134,   -251232188,   1267445783,   1547951569,    740269916,   1776431169,   1687220659,    228229817,    271386089,   -682906779,   -438090344,   1190436796,   -744272540,
            1879221151,   1145200306,  -1730983338,  -1119209309,     90826726,   1567861540,   1638852830,  -1645384932,   1566909531,   1088584561,   1030555565,  -1872052014,    720320695,   -885053674,   -321216789,    739907579,
            368580703,   -443635520,   1232705619,  -1355949988,  -1047211249,  -1571429448,    599299852,   1036970439,   1513838571,    -51797291,    -26647565,  -1262878942,   -916262582,   1579082269,   -292007383,   1289013866,
            -1612184284,   1451738668,    448608569,    476432992,  -1229609565,    786372409,    929928149,   -150100614,    448155944,  -1322320576,   -856549627,   1057443268,  -1536809554,    577508258,    584906122,    275295163,
            -604262071,   -236043234,  -1866434954,  -2072447013,    646132876,    847562546,   -310005953,  -1104162658,    393261203,   -730102354,    440824482,   1654535035,  -1296359745,   1487359328,   -977776604,   -775827779,
            -1298695106,    519080622,   1697162240,    227873031,   -371123123,   1273702312,  -1710063656,  -2138342344,   1139555478,   1531578907,  -1498880699,   1183507362,   1875307493,  -1649740413,   2135386504,   -962458407,
            424161768,    504272962,    202204247,   1783466420,   2015579232,   -676642965,   2067456450,    914480415,   -620398841,   1880405399,   1406637142,   1951104977,    633496157,    224861869,    -58659291,    994942775,
            -479000645,   1421449115,    100168104,    249754169,  -1219011494,   1736303638,    364013694,  -1750035055,   -479217141,   1652913106,  -2109452331,   1633842910,  -1547663337,    936627493,  -1152799743,    896955899,
            -1407742850,   -523769014,    357161414,    872293304,    744895980,    720829676,   -240843156,   -111779524,   1292836315,  -1792141538,   1946959925,   1181751089,  -1120674052,   1185192575,  -1387002557,   1973209255,
            -120887476,   -766577735,   -443913073,    786620227,    428564781,   -101232106,   -425959852,    198082021,   1173272226,  -1744840378,  -1621135606,  -1539498583,  -1101274572,     43399711,  -1256764602,   1201920787,
            2049426139,    846545551,  -2121520873,  -1202939675,   -470425740,    321987390,   1862019060,   -951540342,   -894238318,   -430407175,  -1662746491,    656574776,   1580373777,   -431290218,   1645824323,  -1953526979,
            -374682356,    474291752,   1071558425,    511038981,   -760598678,   -567797285,  -1176476266,   -268409005,  -2130644484,    -67970563,   1756046948,   1429860462,  -1130984739,   -124916495,  -1544436836,  -1863524031,
            1024916487,  -1388636482,  -1573205065,    892628956,   1831270021,   1176430590,   1158914682,  -2006787098,  -1228130033,   1516111488,  -1499151347,    470546266,   1642603981,   1425140838,  -1823071475,  -1775267236,
            -1009380612,    164746986,   1129677098,   1842642579,   -482342932,   -507480364,   1656012309,   1981601761,   -881042120,   -511987083,    342447017,    381192578,    983008095,    741012865,  -1877136350,   -199211983,
            -452784912,   1929572576,  -1678291139,   -864375281,  -1610561247,  -1936356726,   -749553767,   -865893512,   -567081879,  -1303973729,   -939636958,   -622974563,    428284937,   1049237414,    852280765,     86648946,
            -1353851401,  -1045422335,    898035731,  -1636093996,  -1083174191,    245046915,   -359768226,  -1028491655,   1051575118,   1774289451,   1839389415,  -1594053468,    736707953,   1873556950,    401186168,   -583669552,
            -88375334,   2002752071,    264506453,  -1304812107,   -759203942,   -114958524,  -1878903503,    841613720,   1910863820,  -1738114003,    701455920,   1791058048,  -1850960547,   1672292671,   1172188809,    604848896,
            -1607489375,    305370478,   -948153885,  -1971080100,  -1848966954,   -584538365,     39416319,  -1689119162,    944942598,   1777111075,   1534005553,   2022718432,    -25820385,      3077695,   -315950520,   1859184648,
            -1397829266,  -1666371809,    858913807,   -610818620,   1554973298,    580023809,  -1662988256,   -408630026,   1316681876,    738204271,    942829881,   -758486983,    780345857,    667165037,  -2086803585,    789741324
        };

        for (int i = 0; i < refInt.length; ++i) {
            Assert.assertEquals(refInt[i], rng.nextInt());
        }
    }
}
