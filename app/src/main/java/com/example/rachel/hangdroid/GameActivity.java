package com.example.rachel.hangdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class GameActivity extends ActionBarActivity {

    String nWord;
    int nfailedCounter = 0;
    int nGuessedLetters = 0;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setRandomWord();
    }


    /**
     * Retrieving the letter introduced on the editText
     *
     * @param view (button clicked)
     */
    public void introduceLetter(View view){

        EditText myEditText =(EditText)findViewById(R.id.etInsertedLetter);

        String letter = myEditText.getText().toString();
        myEditText.setText("");

        Log.d("MYLOG", "The letter introduced is " + letter);
        if(letter.length() == 1){
            checkLetter(letter.toUpperCase());
        }else {
            Toast.makeText(this, "Enter a letter", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * checking if the letter entered matches any letter of the word to guess
     *
     * @param introduceLetter, letter enterd by the user
     */
    public void checkLetter(String introduceLetter){

        char charIntroduced = introduceLetter.charAt(0);
        boolean letterGuessed = false;

        for(int i = 0; i < nWord.length(); i++){

            char charFromTheWord =nWord.charAt(i);

            if(charFromTheWord == charIntroduced){
                Log.d("MYLOG", "There was one match");

                letterGuessed = true;

                showLettersAtIndex(i,charIntroduced);

                nGuessedLetters++;
            }
        }
        if(letterGuessed == false){
            displayFailedLetter(introduceLetter);
            letterFailed();

        }

        if(nGuessedLetters == nWord.length()){

            points++;
            clearScreen();
           setRandomWord();
        }

    }

    public  void setRandomWord(){
        String word = "AAHS AALS ABAS ABBA ABBE ABED ABET ABLE ABLY ABOS ABRI ABUT ABYE ABYS ACED ACES ACHE ACHY ACID ACME ACNE ACRE ACTA ACTS ACYL ADDS ADIT ADOS ADZE AEON AERO AERY AFAR AGAR AGAS AGED AGEE AGER AGES AGHA AGIN AGIO AGLY AGMA AGOG AGON AGUE AHEM AHOY AIDE AIDS AILS AIMS AINS AIRN AIRS AIRT AIRY AITS AJAR AJEE AKEE AKIN ALAE ALAN ALAR ALAS ALBA ALBS ALEC ALEE ALEF ALES ALFA ALGA ALIF ALIT ALKY ALLS ALLY ALMA ALME ALMS ALOE ALOW ALPS ALSO ALTO ALTS ALUM AMAH AMAS AMBO AMEN AMIA AMID AMIE AMIN AMIR AMIS AMMO AMOK AMPS AMUS AMYL ANAL ANAS ANDS ANES ANEW ANGA ANIL ANIS ANKH ANNA ANOA ANON ANSA ANTA ANTE ANTI ANTS ANUS APED APER APES APEX APOD APSE AQUA ARAK ARBS ARCH ARCO ARCS AREA ARES ARFS ARIA ARID ARIL ARKS ARMS ARMY ARSE ARTS ARTY ARUM ARVO ARYL ASCI ASEA ASHY ASKS ASPS ATAP ATES ATMA ATOM ATOP AUKS AULD AUNT AURA AUTO AVER AVES AVID AVOS AVOW AWAY AWED AWEE AWES AWLS AWNS AWNY AWOL AWRY AXAL AXED AXEL AXES AXIL AXIS AXLE AXON AYAH AYES AYIN AZAN AZON BAAL BAAS BABA BABE BABU BABY BACH BACK BADE BADS BAFF BAGS BAHT BAIL BAIT BAKE BALD BALE BALK BALL BALM BALS BAMS BAND BANE BANG BANI BANK BANS BAPS BARB BARD BARE BARF BARK BARM BARN BARS BASE BASH BASK BASS BAST BATE BATH BATS BATT BAUD BAWD BAWL BAYS BEAD BEAK BEAM BEAN BEAR BEAT BEAU BECK BEDS BEDU BEEF BEEN BEEP BEER BEES BEET BEGS BELL BELS BELT BEMA BEND BENE BENS BENT BERG BERM BEST BETA BETH BETS BEVY BEYS BHUT BIAS BIBB BIBS BICE BIDE BIDS BIER BIFF BIGS BIKE BILE BILK BILL BIMA BIND BINE BINS BINT BIOS BIRD BIRK BIRL BIRR BISE BISK BITE BITS BITT BIZE BLAB BLAE BLAH BLAM BLAT BLAW BLEB BLED BLET BLEW BLIN BLIP BLOB BLOC BLOG BLOT BLOW BLUB BLUE BLUR BOAR BOAS BOAT BOBS BOCK BODE BODS BODY BOFF BOGS BOGY BOIL BOLA BOLD BOLE BOLL BOLO BOLT BOMB BOND BONE BONG BONK BONY BOOB BOOK BOOM BOON BOOR BOOS BOOT BOPS BORA BORE BORN BORT BOSH BOSK BOSS BOTA BOTH BOTS BOTT BOUT BOWL BOWS BOXY BOYO BOYS BOZO BRAD BRAE BRAG BRAN BRAS BRAT BRAW BRAY BRED BREE BREN BREW BRIE BRIG BRIM BRIN BRIO BRIS BRIT BROO BROS BROW BRRR BRUT BUBO BUBS BUCK BUDS BUFF BUGS BUHL BUHR BULB BULK BULL BUMF BUMP BUMS BUND BUNG BUNK BUNN BUNS BUNT BUOY BURA BURD BURG BURL BURN BURP BURR BURS BURY BUSH BUSK BUSS BUST BUSY BUTE BUTS BUTT BUYS BUZZ BYES BYRE BYRL BYTE CABS CACA CADE CADI CADS CAFE CAFF CAFS CAGE CAGY CAID CAIN CAKE CAKY CALF CALK CALL CALM CALO CALX CAME CAMP CAMS CANE CANS CANT CAPE CAPH CAPO CAPS CARB CARD CARE CARK CARL CARN CARP CARR CARS CART CASA CASE CASH CASK CAST CATE CATS CAUL CAVE CAVY CAWS CAYS CAZH CECA CEDE CEDI CEES CEIL CELL CELS CELT CENT CEPE CEPS CERE CERO CESS CETE CHAD CHAM CHAO CHAP CHAR CHAT CHAW CHAY CHEF CHEW CHEZ CHIA CHIC CHID CHIN CHIP CHIS CHIT CHON CHOP CHOW CHUB CHUG CHUM CIAO CINE CION CIRE CIST CITE CITY CLAD CLAG CLAM CLAN CLAP CLAW CLAY CLEF CLEW CLIP CLOD CLOG CLON CLOP CLOT CLOY CLUB CLUE COAL COAT COAX COBB COBS COCA COCK COCO CODA CODE CODS COED COFF COFT COGS COHO COIF COIL COIN COIR COKE COLA COLD COLE COLS COLT COLY COMA COMB COME COMP CONE CONI CONK CONN CONS CONY COOF COOK COOL COON COOP COOS COOT COPE COPS COPY CORD CORE CORF CORK CORM CORN CORY COSH COSS COST COSY COTE COTS COUP COVE COWL COWS COWY COXA COYS COZY CRAB CRAG CRAM CRAP CRAW CREW CRIB CRIS CROC CROP CROW CRUD CRUS CRUX CUBE CUBS CUDS CUED CUES CUFF CUIF CUKE CULL CULM CULT CUNT CUPS CURB CURD CURE CURF CURL CURN CURR CURS CURT CUSK CUSP CUSS CUTE CUTS CWMS CYAN CYMA CYME CYST CZAR DABS DACE DADA DADO DADS DAFF DAFT DAGO DAGS DAHL DAHS DAIS DAKS DALE DALS DAME DAMN DAMP DAMS DANG DANK DAPS DARB DARE DARK DARN DART DASH DATA DATE DATO DAUB DAUT DAVY DAWK DAWN DAWS DAWT DAYS DAZE DEAD DEAF DEAL DEAN DEAR DEBS DEBT DECK DECO DEED DEEM DEEP DEER DEES DEET DEFI DEFT DEFY DEIL DEKE DELE DELF DELI DELL DELS DEME DEMO DEMY DENE DENS DENT DENY DERE DERM DESK DEVA DEVS DEWS DEWY DEXY DEYS DHAK DHAL DHOW DIAL DIBS DICE DICK DIDO DIDY DIED DIEL DIES DIET DIGS DIKE DILL DIME DIMS DINE DING DINK DINS DINT DIOL DIPS DIPT DIRE DIRK DIRL DIRT DISC DISH DISK DISS DITA DITE DITS DITZ DIVA DIVE DJIN DOAT DOBY DOCK DOCS DODO DOER DOES DOFF DOGE DOGS DOGY DOHS DOIT DOJO DOLE DOLL DOLS DOLT DOME DOMS DONA DONE DONG DONS DOOM DOOR DOPA DOPE DOPY DORE DORK DORM DORP DORR DORS DORY DOSE DOSS DOST DOTE DOTH DOTS DOTY DOUM DOUR DOUX DOVE DOWN DOWS DOXY DOZE DOZY DRAB DRAG DRAM DRAT DRAW DRAY DREE DREG DREK DREW DRIB DRIP DROP DRUB DRUG DRUM DRYS DUAD DUAL DUBS DUCE DUCI DUCK DUCT DUDE DUDS DUEL DUES DUET DUFF DUGS DUIT DUKE DULL DULY DUMA DUMB DUMP DUNE DUNG DUNK DUNS DUNT DUOS DUPE DUPS DURA DURE DURN DURO DURR DUSK DUST DUTY DYAD DYED DYER DYES DYKE DYNE EACH EARL EARN EARS EASE EAST EASY EATH EATS EAUX EAVE EBBS EBON ECHE ECHO ECOS ECRU ECUS EDDO EDDY EDGE EDGY EDHS EDIT EELS EELY EERY EFFS EFTS EGAD EGAL EGER EGGS EGGY EGIS EGOS EIDE EKED EKES ELAN ELDS ELHI ELKS ELLS ELMS ELMY ELSE EMES EMEU EMFS EMIC EMIR EMIT EMOS EMUS EMYD ENDS ENGS ENOL ENOW ENUF ENVY EONS EPEE EPHA EPIC EPOS ERAS ERGO ERGS ERNE ERNS EROS ERRS ERST ESES ESPY ESTS ETAS ETCH ETHS ETIC ETNA ETUI EURO EVEN EVER EVES EVIL EWER EWES EXAM EXEC EXES EXIT EXON EXPO EYAS EYED EYEN EYER EYES EYNE EYRA EYRE EYRY FACE FACT FADE FADO FADS FAGS FAHS FAIL FAIN FAIR FAKE FALL FALX FAME FANE FANG FANO FANS FARD FARE FARL FARM FARO FART FASH FAST FATE FATS FAUN FAUX FAVA FAVE FAWN FAYS FAZE FEAL FEAR FEAT FECK FEDS FEED FEEL FEES FEET FEHS FELL FELT FEME FEMS FEND FENS FEOD FERE FERN FESS FETA FETE FETS FEUD FEUS FIAR FIAT FIBS FICE FICO FIDO FIDS FIEF FIFE FIGS FILA FILE FILL FILM FILO FILS FIND FINE FINK FINO FINS FIRE FIRM FIRN FIRS FISC FISH FIST FITS FIVE FIXT FIZZ FLAB FLAG FLAK FLAM FLAN FLAP FLAT FLAW FLAX FLAY FLEA FLED FLEE FLEW FLEX FLEY FLIC FLIP FLIT FLOC FLOE FLOG FLOP FLOW FLUB FLUE FLUS FLUX FOAL FOAM FOBS FOCI FOES FOGS FOGY FOHN FOIL FOIN FOLD FOLK FOND FONS FONT FOOD FOOL FOOS FOOT FOPS FORA FORB FORD FORE FORK FORM FORT FOSS FOUL FOUR FOWL FOXY FOYS FOZY FRAE FRAG FRAP FRAT FRAY FREE FRET FRIG FRIT FRIZ FROE FROG FROM FROW FRUG FUBS FUCI FUCK FUDS FUEL FUGS FUGU FUJI FULL FUME FUMY FUND FUNK FUNS FURL FURS FURY FUSE FUSS FUTZ FUZE FUZZ FYCE FYKE GABS GABY GADI GADS GAED GAEN GAES GAFF GAGA GAGE GAGS GAIN GAIT GALA GALE GALL GALS GAMA GAMB GAME GAMP GAMS GAMY GANE GANG GAOL GAPE GAPS GAPY GARB GARS GASH GASP GAST GATE GATS GAUD GAUM GAUN GAUR GAVE GAWK GAWP GAYS GAZE GEAR GECK GEDS GEED GEEK GEES GEEZ GELD GELS GELT GEMS GENE GENS GENT GENU GERM GEST GETA GETS GEUM GHAT GHEE GHIS GIBE GIBS GIDS GIED GIEN GIES GIFS GIFT GIGA GIGS GILD GILL GILT GIMP GINK GINS GIPS GIRD GIRL GIRN GIRO GIRT GIST GITS GIVE GLAD GLED GLEE GLEG GLEN GLEY GLIA GLIB GLIM GLOB GLOM GLOP GLOW GLUE GLUG GLUM GLUT GNAR GNAT GNAW GNUS GOAD GOAL GOAS GOAT GOBO GOBS GOBY GODS GOER GOES GOGO GOLD GOLF GONE GONG GOOD GOOF GOOK GOON GOOP GOOS GORE GORP GORY GOSH GOTH GOUT GOWD GOWK GOWN GOYS GRAB GRAD GRAM GRAN GRAT GRAY GREE GREW GREY GRID GRIG GRIM GRIN GRIP GRIT GROG GROT GROW GRUB GRUE GRUM GUAN GUAR GUCK GUDE GUFF GUID GULF GULL GULP GULS GUMS GUNK GUNS GURU GUSH GUST GUTS GUVS GUYS GYBE GYMS GYPS GYRE GYRI GYRO GYVE HAAF HAAR HABU HACK HADE HADJ HAED HAEM HAEN HAES HAET HAFT HAGS HAHA HAHS HAIK HAIL HAIR HAJI HAJJ HAKE HALE HALF HALL HALM HALO HALT HAME HAMS HAND HANG HANK HANT HAPS HARD HARE HARK HARL HARM HARP HART HASH HASP HAST HATE HATH HATS HAUL HAUT HAVE HAWK HAWS HAYS HAZE HAZY HEAD HEAL HEAP HEAR HEAT HEBE HECK HEED HEEL HEFT HEHS HEIL HEIR HELD HELL HELM HELO HELP HEME HEMP HEMS HENS HENT HERB HERD HERE HERL HERM HERN HERO HERS HEST HETH HETS HEWN HEWS HICK HIDE HIED HIES HIGH HIKE HILA HILI HILL HILT HIND HINS HINT HIPS HIRE HISN HISS HIST HITS HIVE HOAR HOAX HOBO HOBS HOCK HODS HOED HOER HOES HOGG HOGS HOKE HOLD HOLE HOLK HOLM HOLP HOLS HOLT HOLY HOME HOMO HOMS HOMY HONE HONG HONK HONS HOOD HOOF HOOK HOOP HOOT HOPE HOPS HORA HORN HOSE HOST HOTS HOUR HOVE HOWE HOWF HOWK HOWL HOWS HOYA HOYS HUBS HUCK HUED HUES HUFF HUGE HUGS HUIC HULA HULK HULL HUMP HUMS HUNG HUNH HUNK HUNS HUNT HURL HURT HUSH HUSK HUTS HWAN HYLA HYMN HYPE HYPO HYPS HYTE IAMB IBEX IBIS ICED ICES ICHS ICKY ICON IDEA IDEM IDES IDLE IDLY IDOL IDYL IFFY IGLU IKAT IKON ILEA ILEX ILIA ILKA ILKS ILLS ILLY IMAM IMID IMMY IMPI IMPS INBY INCH INFO INIA INKS INKY INLY INNS INRO INTI INTO IONS IOTA IRED IRES IRID IRIS IRKS IRON ISBA ISLE ISMS ITCH ITEM IWIS IXIA IZAR JABS JACK JADE JAGG JAGS JAIL JAKE JAMB JAMS JANE JAPE JARL JARS JATO JAUK JAUP JAVA JAWS JAYS JAZZ JEAN JEED JEEP JEER JEES JEEZ JEFE JEHU JELL JEON JERK JESS JEST JETE JETS JEUX JEWS JIAO JIBB JIBE JIBS JIFF JIGS JILL JILT JIMP JINK JINN JINS JINX JISM JIVE JOBS JOCK JOES JOEY JOGS JOHN JOIN JOKE JOKY JOLE JOLT JOSH JOSS JOTA JOTS JOUK JOWL JOWS JOYS JUBA JUBE JUDO JUGA JUGS JUJU JUKE JUMP JUNK JUPE JURA JURY JUST JUTE JUTS KAAS KABS KADI KAES KAFS KAGU KAIF KAIL KAIN KAKA KAKI KALE KAME KAMI KANA KANE KAON KAPA KAPH KARN KART KATA KATS KAVA KAYO KAYS KBAR KEAS KECK KEEF KEEK KEEL KEEN KEEP KEET KEFS KEGS KEIR KELP KEMP KENO KENS KENT KEPI KEPS KEPT KERB KERF KERN KETO KEYS KHAF KHAN KHAT KHET KHIS KIBE KICK KIDS KIEF KIER KIFS KIKE KILL KILN KILO KILT KINA KIND KINE KING KINK KINO KINS KIPS KIRK KIRN KIRS KISS KIST KITE KITH KITS KIVA KIWI KNAP KNAR KNEE KNEW KNIT KNOB KNOP KNOT KNOW KNUR KOAN KOAS KOBO KOBS KOEL KOHL KOLA KOLO KONK KOOK KOPH KOPS KORE KORS KOSS KOTO KRIS KUDO KUDU KUES KURU KVAS KYAK KYAR KYAT KYTE LABS LACE LACK LACS LACY LADE LADS LADY LAGS LAHS LAIC LAID LAIN LAIR LAKE LAKH LAKY LALL LAMA LAMB LAME LAMP LAMS LAND LANE LANG LANK LAPS LARD LARI LARK LARS LASE LASH LASS LAST LATE LATH LATI LATS LAUD LAVA LAVE LAVS LAWN LAWS LAYS LAZE LAZY LEAD LEAF LEAK LEAL LEAN LEAP LEAR LEAS LECH LEEK LEER LEES LEET LEFT LEGS LEHR LEIS LEKE LEKS LEKU LEND LENO LENS LENT LEPT LESS LEST LETS LEUD LEVA LEVO LEVY LEWD LEYS LIAR LIBS LICE LICH LICK LIDO LIDS LIED LIEF LIEN LIER LIES LIEU LIFE LIFT LIKE LILT LILY LIMA LIMB LIME LIMN LIMO LIMP LIMY LINE LING LINK LINN LINO LINS LINT LINY LION LIPS LIRA LIRE LIRI LISP LIST LITE LITS LITU LIVE LOAD LOAF LOAM LOAN LOBE LOBO LOBS LOCA LOCH LOCI LOCK LOCO LODE LOFT LOGE LOGO LOGS LOGY LOIN LOLL LONE LONG LOOF LOOK LOOM LOON LOOP LOOS LOOT LOPE LOPS LORD LORE LORN LORY LOSE LOSS LOST LOTA LOTH LOTI LOTS LOUD LOUP LOUR LOUT LOVE LOWE LOWN LOWS LUAU LUBE LUCE LUCK LUDE LUDS LUES LUFF LUGE LUGS LULL LULU LUMP LUMS LUNA LUNE LUNG LUNK LUNT LUNY LURE LURK LUSH LUST LUTE LUTZ LUVS LUXE LWEI LYES LYNX LYRE LYSE MAAR MABE MACE MACH MACK MACS MADE MADS MAES MAGE MAGI MAGS MAID MAIL MAIM MAIN MAIR MAKE MAKO MALE MALL MALM MALT MAMA MAMS MANA MANE MANO MANS MANY MAPS MARC MARE MARK MARL MARS MART MASH MASK MASS MAST MATE MATH MATS MATT MAUD MAUL MAUN MAUT MAWN MAWS MAXI MAYA MAYO MAYS MAZE MAZY MEAD MEAL MEAN MEAT MEED MEEK MEET MELD MELL MELS MELT MEMO MEMS MEND MENO MENU MEOU MEOW MERE MERK MERL MESA MESH MESS META METE METH MEWL MEWS MEZE MHOS MIBS MICA MICE MICK MICS MIDI MIDS MIEN MIFF MIGG MIGS MIKE MILD MILE MILK MILL MILO MILS MILT MIME MINA MIND MINE MINI MINK MINT MINX MIRE MIRI MIRK MIRS MIRY MISE MISO MISS MIST MITE MITT MITY MIXT MOAN MOAS MOAT MOBS MOCK MOCS MODE MODI MODS MOGS MOIL MOJO MOKE MOLA MOLD MOLE MOLL MOLS MOLT MOLY MOME MOMI MOMS MONK MONO MONS MONY MOOD MOOL MOON MOOR MOOS MOOT MOPE MOPS MOPY MORA MORE MORN MORS MORT MOSK MOSS MOST MOTE MOTH MOTS MOTT MOUE MOVE MOWN MOWS MOXA MOZO MUCH MUCK MUDS MUFF MUGG MUGS MULE MULL MUMM MUMP MUMS MUMU MUNI MUNS MUON MURA MURE MURK MURR MUSE MUSH MUSK MUSS MUST MUTE MUTS MUTT MYNA MYTH NAAN NABE NABS NADA NAGS NAIF NAIL NAME NANA NANS NAOI NAOS NAPE NAPS NARC NARD NARK NARY NAVE NAVY NAYS NAZI NEAP NEAR NEAT NEBS NECK NEED NEEM NEEP NEIF NEMA NENE NEON NERD NESS NEST NETS NETT NEUK NEUM NEVE NEVI NEWB NEWS NEWT NEXT NIBS NICE NICK NIDE NIDI NIGH NILL NILS NIMS NINE NIPA NIPS NISI NITE NITS NIXE NIXY NOBS NOCK NODE NODI NODS NOEL NOES NOGG NOGS NOIL NOIR NOLO NOMA NOME NOMS NONA NONE NOOK NOON NOPE NORI NORM NOSE NOSH NOSY NOTA NOTE NOUN NOUS NOVA NOWS NOWT NUBS NUDE NUKE NULL NUMB NUNS NURD NURL NUTS OAFS OAKS OARS OAST OATH OATS OBES OBEY OBIA OBIS OBIT OBOE OBOL OCAS ODDS ODEA ODES ODIC ODOR ODYL OFAY OFFS OGAM OGEE OGLE OGRE OHED OHIA OHMS OIKS OILS OILY OINK OKAS OKAY OKEH OKES OKRA OLDS OLDY OLEA OLEO OLES OLIO OLLA OMEN OMER OMIT ONCE ONES ONLY ONTO ONUS ONYX OOHS OOPS OOTS OOZE OOZY OPAH OPAL OPED OPEN OPES OPTS OPUS ORAD ORAL ORBS ORBY ORCA ORCS ORDO ORES ORGY ORLE ORRA ORTS ORYX ORZO OSAR OSES OSSA OTIC OTTO OUCH OUDS OUPH OURS OUST OUTS OUZO OVAL OVEN OVER OVUM OWED OWES OWLS OWNS OWSE OWTS OXEN OXES OXID OXIM OYER OYES OYEZ PACA PACE PACK PACS PACT PADI PADS PAGE PAID PAIK PAIL PAIN PAIR PALE PALL PALM PALP PALS PALY PAMS PANE PANG PANS PANT PAPA PAPS PARA PARD PARE PARK PARR PARS PART PASE PASH PASS PAST PATE PATH PATS PATY PAVE PAWL PAWN PAWS PAYS PEAG PEAK PEAL PEAN PEAR PEAS PEAT PECH PECK PECS PEDS PEED PEEK PEEL PEEN PEEP PEER PEES PEGS PEHS PEIN PEKE PELE PELF PELT PEND PENS PENT PEON PEPO PEPS PERI PERK PERM PERT PERV PESO PEST PETS PEWS PFFT PFUI PHAT PHEW PHIS PHIZ PHON PHOS PHOT PHUT PIAL PIAN PIAS PICA PICE PICK PICS PIED PIER PIES PIGS PIKA PIKE PIKI PILE PILI PILL PILY PIMA PIMP PINA PINE PING PINK PINS PINT PINY PION PIPE PIPS PIPY PIRN PISH PISO PISS PITA PITH PITS PITY PIXY PLAN PLAT PLAY PLEA PLEB PLED PLEW PLIE PLOD PLOP PLOT PLOW PLOY PLUG PLUM PLUS POCK POCO PODS POEM POET POGY POIS POKE POKY POLE POLL POLO POLS POLY POME POMP POMS POND PONE PONG PONS PONY POOD POOF POOH POOL POON POOP POOR POPE POPS PORE PORK PORN PORT POSE POSH POST POSY POTS POUF POUR POUT POWS PRAM PRAO PRAT PRAU PRAY PREE PREP PREX PREY PREZ PRIG PRIM PROA PROD PROF PROG PROM PROP PROS PROW PSIS PSST PUBS PUCE PUCK PUDS PUFF PUGH PUGS PUJA PUKE PULA PULE PULI PULL PULP PULS PUMA PUMP PUNA PUNG PUNK PUNS PUNT PUNY PUPA PUPS PURE PURI PURL PURR PURS PUSH PUSS PUTS PUTT PUTZ PYAS PYES PYIC PYIN PYRE QADI QAID QATS QOPH QUAD QUAG QUAI QUAY QUEY QUID QUIN QUIP QUIT QUIZ QUOD RACE RACK RACY RADS RAFF RAFT RAGA RAGE RAGI RAGS RAIA RAID RAIL RAIN RAJA RAKE RAKI RALE RAMI RAMP RAMS RAND RANG RANI RANK RANT RAPE RAPS RAPT RARE RASE RASH RASP RATE RATH RATO RATS RAVE RAWS RAYA RAYS RAZE RAZZ READ REAL REAM REAP REAR REBS RECK RECS REDD REDE REDO REDS REED REEF REEK REEL REES REFS REFT REGS REIF REIN REIS RELY REMS REND RENT REPO REPP REPS RESH REST RETE RETS REVS RHEA RHOS RHUS RIAL RIAS RIBS RICE RICH RICK RIDE RIDS RIEL RIFE RIFF RIFS RIFT RIGS RILE RILL RIME RIMS RIMY RIND RING RINK RINS RIOT RIPE RIPS RISE RISK RITE RITZ RIVE ROAD ROAM ROAN ROAR ROBE ROBS ROCK ROCS RODE RODS ROES ROIL ROLE ROLF ROLL ROMP ROMS ROOD ROOF ROOK ROOM ROOS ROOT ROPE ROPY ROSE ROSY ROTA ROTE ROTI ROTL ROTO ROTS ROUE ROUP ROUT ROUX ROVE ROWS RUBE RUBS RUBY RUCK RUDD RUDE RUED RUER RUES RUFF RUGA RUGS RUIN RULE RULY RUMP RUMS RUNE RUNG RUNS RUNT RUSE RUSH RUSK RUST RUTH RUTS RYAS RYES RYKE RYND RYOT SABE SABS SACK SACS SADE SADI SAFE SAGA SAGE SAGO SAGS SAGY SAID SAIL SAIN SAKE SAKI SALE SALL SALP SALS SALT SAME SAMP SAND SANE SANG SANK SANS SAPS SARD SARI SARK SASH SASS SATE SATI SAUL SAVE SAWN SAWS SAYS SCAB SCAD SCAG SCAM SCAN SCAR SCAT SCOP SCOT SCOW SCRY SCUD SCUM SCUP SCUT SEAL SEAM SEAR SEAS SEAT SECS SECT SEED SEEK SEEL SEEM SEEN SEEP SEER SEES SEGO SEGS SEIF SEIS SELF SELL SELS SEME SEMI SEND SENE SENT SEPT SERA SERE SERF SERS SETA SETS SETT SEWN SEWS SEXT SEXY SHAD SHAG SHAH SHAM SHAT SHAW SHAY SHEA SHED SHES SHEW SHIM SHIN SHIP SHIT SHIV SHMO SHOD SHOE SHOG SHOO SHOP SHOT SHOW SHRI SHUL SHUN SHUT SIAL SIBB SIBS SICE SICK SICS SIDE SIFT SIGH SIGN SIGS SIKE SILD SILK SILL SILO SILT SIMA SIMP SIMS SINE SING SINH SINK SINS SIPE SIPS SIRE SIRS SITE SITH SITS SIZE SIZY SKAG SKAS SKAT SKEE SKEG SKEP SKEW SKID SKIM SKIN SKIP SKIS SKIT SKUA SLAB SLAG SLAM SLAP SLAT SLAW SLAY SLED SLEW SLID SLIM SLIP SLIT SLOB SLOE SLOG SLOP SLOT SLOW SLUB SLUE SLUG SLUM SLUR SLUT SMEW SMIT SMOG SMUG SMUT SNAG SNAP SNAW SNED SNIB SNIP SNIT SNOB SNOG SNOT SNOW SNUB SNUG SNYE SOAK SOAP SOAR SOBS SOCK SODA SODS SOFA SOFT SOHS SOIL SOJA SOJU SOKE SOLA SOLD SOLE SOLI SOLO SOLS SOMA SOME SONE SONG SONS SOOK SOON SOOT SOPH SOPS SORA SORB SORD SORE SORI SORN SORT SOTH SOTS SOUK SOUL SOUP SOUR SOUS SOWN SOWS SOYA SOYS SPAE SPAN SPAR SPAS SPAT SPAY SPAZ SPEC SPED SPEW SPIC SPIK SPIN SPIT SPIV SPOT SPRY SPUD SPUE SPUN SPUR SRIS STAB STAG STAR STAT STAW STAY STEM STEP STET STEW STEY STIR STOA STOB STOP STOW STUB STUD STUM STUN STYE SUBA SUBS SUCH SUCK SUDD SUDS SUED SUER SUES SUET SUGH SUIT SULK SULU SUMO SUMP SUMS SUNG SUNK SUNN SUNS SUPE SUPS SUQS SURA SURD SURE SURF SUSS SWAB SWAG SWAM SWAN SWAP SWAT SWAY SWIG SWIM SWOB SWOP SWOT SWUM SYBO SYCE SYKE SYLI SYNC SYNE SYPH TABS TABU TACE TACH TACK TACO TACT TADS TAEL TAGS TAHR TAIL TAIN TAKA TAKE TALA TALC TALE TALI TALK TALL TAME TAMP TAMS TANG TANK TANS TAOS TAPA TAPE TAPS TARE TARN TARO TARP TARS TART TASE TASK TASS TATE TATS TAUS TAUT TAVS TAWS TAXA TAXI TEAK TEAL TEAM TEAR TEAS TEAT TECS TEDS TEED TEEL TEEM TEEN TEES TEFF TEGS TELA TELE TELL TELS TEMP TEND TENS TENT TEPA TERM TERN TEST TETH TETS TEWS TEXT THAE THAN THAT THAW THEE THEM THEN THEW THEY THIN THIO THIR THIS THOU THRO THRU THUD THUG THUS TICK TICS TIDE TIDY TIED TIER TIES TIFF TIKE TIKI TILE TILL TILS TILT TIME TINE TING TINS TINT TINY TIPI TIPS TIRE TIRL TIRO TITI TITS TIVY TOAD TOBY TODS TODY TOEA TOED TOES TOFF TOFT TOFU TOGA TOGS TOIL TOIT TOKE TOLA TOLD TOLE TOLL TOLU TOMB TOME TOMS TONE TONG TONS TONY TOOK TOOL TOOM TOON TOOT TOPE TOPH TOPI TOPS TORA TORC TORE TORI TORN TORO TORR TORS TORT TORY TOSH TOSS TOST TOTE TOTS TOUR TOUT TOWN TOWS TOWY TOYO TOYS TRAD TRAM TRAP TRAY TREE TREF TREK TRET TREY TRIG TRIM TRIO TRIP TROD TROP TROT TROW TROY TRUE TRUG TSAR TSKS TUBA TUBE TUBS TUCK TUFA TUFF TUFT TUGS TUIS TULE TUMP TUNA TUNE TUNG TUNS TUPS TURD TURF TURK TURN TUSH TUSK TUTS TUTU TWAE TWAS TWAT TWEE TWIG TWIN TWIT TWOS TYEE TYER TYES TYKE TYNE TYPE TYPO TYPP TYPY TYRE TYRO TZAR UDOS UGHS UGLY UKES ULAN ULNA ULUS ULVA UMBO UMPS UNAI UNAU UNBE UNCI UNCO UNDE UNDO UNDY UNIT UNTO UPAS UPBY UPDO UPON URBS URDS UREA URGE URIC URNS URSA URUS USED USER USES UTAS UVEA VACS VAGI VAIL VAIN VAIR VALE VAMP VANE VANG VANS VARA VARS VARY VASA VASE VAST VATS VATU VAUS VAVS VAWS VEAL VEEP VEER VEES VEIL VEIN VELA VELD VENA VEND VENT VERA VERB VERT VERY VEST VETO VETS VEXT VIAL VIBE VICE VIDE VIED VIER VIES VIEW VIGA VIGS VILE VILL VIMS VINA VINE VINO VINS VINY VIOL VIRL VISA VISE VITA VIVA VIVE VOES VOID VOLE VOLT VOTE VOWS VROW VUGG VUGH VUGS WABS WACK WADE WADI WADS WADY WAES WAFF WAFT WAGE WAGS WAIF WAIL WAIN WAIR WAIT WAKE WALE WALK WALL WALY WAME WAND WANE WANS WANT WANY WAPS WARD WARE WARK WARM WARN WARP WARS WART WARY WASH WASP WAST WATS WATT WAUK WAUL WAUR WAVE WAVY WAWL WAWS WAXY WAYS WEAK WEAL WEAN WEAR WEBS WEDS WEED WEEK WEEL WEEN WEEP WEER WEES WEET WEFT WEIR WEKA WELD WELL WELT WEND WENS WENT WEPT WERE WERT WEST WETS WHAM WHAP WHAT WHEE WHEN WHET WHEW WHEY WHID WHIG WHIM WHIN WHIP WHIR WHIT WHIZ WHOA WHOM WHOP WHYS WICH WICK WIDE WIFE WIGS WILD WILE WILL WILT WILY WIMP WIND WINE WING WINK WINO WINS WINY WIPE WIRE WIRY WISE WISH WISP WISS WIST WITE WITH WITS WIVE WOAD WOES WOGS WOKE WOKS WOLD WOLF WOMB WONK WONS WONT WOOD WOOF WOOL WOOS WOPS WORD WORE WORK WORM WORN WORT WOST WOTS WOVE WOWS WRAP WREN WRIT WUSS WYCH WYES WYLE WYND WYNN WYNS WYTE XYST YACK YAFF YAGI YAKS YALD YAMS YANG YANK YAPS YARD YARE YARN YAUD YAUP YAWL YAWN YAWP YAWS YAYS YEAH YEAN YEAR YEAS YECH YEGG YELD YELK YELL YELP YENS YERK YETI YETT YEUK YEWS YIDS YILL YINS YIPE YIPS YIRD YIRR YLEM YOBS YOCK YODH YODS YOGA YOGH YOGI YOKE YOKS YOLK YOND YONI YORE YOUR YOWE YOWL YOWS YUAN YUCA YUCH YUCK YUGA YUKS YULE YUPS YURT YWIS ZAGS ZANY ZAPS ZARF ZEAL ZEBU ZEDS ZEES ZEIN ZEKS ZERK ZERO ZEST ZETA ZIGS ZILL ZINC ZINE ZING ZINS ZIPS ZITI ZITS ZOEA ZOIC ZONE ZONK ZOOM ZOON ZOOS ZORI ZYME";

        String[] arrayWords = word.split(" ");

        int randomIndex = (int)(Math.random()*(arrayWords.length));

        nWord = arrayWords[randomIndex];

    }

    public  void clearScreen(){
        TextView tvIncorrectLetters = (TextView) findViewById(R.id.tvIncorrectLetters);
        tvIncorrectLetters.setText("");

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);
        for(int i = 0; i < layoutLetters.getChildCount(); i++){
            TextView currentTextView = (TextView) layoutLetters.getChildAt(i);
            currentTextView.setText("_");
        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.hangdroid_0);

        nGuessedLetters =0;
        nfailedCounter =0;

    }

    public void letterFailed(){
        nfailedCounter++;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        if(nfailedCounter == 1){
            imageView.setImageResource(R.drawable.hangdroid_1);
        }else if(nfailedCounter == 2){
            imageView.setImageResource(R.drawable.hangdroid_2);
        }else  if(nfailedCounter == 3){
            imageView.setImageResource(R.drawable.hangdroid_3);
        }else if(nfailedCounter == 4){
            imageView.setImageResource(R.drawable.hangdroid_4);
        }else  if(nfailedCounter == 5){
            imageView.setImageResource(R.drawable.hangdroid_5);
        }else if(nfailedCounter == 6){
            Intent gameOverIntent = new Intent(this,GameOverActivity.class);
            gameOverIntent.putExtra("POINTS_IDENTIFIER",points);
            gameOverIntent.putExtra("CORRECT_WORD",nWord);
            startActivity(gameOverIntent);

            finish();
     }
    }

    public void displayFailedLetter(String introduceLetter){

        TextView tvIncorrectLetters = (TextView) findViewById(R.id.tvIncorrectLetters);

        String incorrectLetters = tvIncorrectLetters.getText().toString();

        boolean isGuessed = false;
        for (int i = 0; i < incorrectLetters.length(); i++){
            if(incorrectLetters.charAt(i) == introduceLetter.charAt(0)) {
                --nfailedCounter;
                isGuessed = true;
                Toast.makeText(this, "You already guessed this letter! Try another  letter", Toast.LENGTH_SHORT).show();

            }
        }

        if(isGuessed == false) {
            tvIncorrectLetters.setText(incorrectLetters + " " + introduceLetter);
        }
    }

    /**
     * Displaying a letter passed by the user
     * @param position of the letter
     * @param letterGuessed
     */
    public  void showLettersAtIndex(int position, char letterGuessed){

        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);

        TextView textView = (TextView) layoutLetter.getChildAt(position);

        textView.setText(Character.toString(letterGuessed));
    }


}
