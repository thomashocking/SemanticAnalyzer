# SemanticAnalyzer
**Semantic Analyzer is a natural language processing program.**


It analyzes a text format file. Then extract the significant sentences from the text based on the controlled vocabulary database. The controlled vocabulary database can be modified by users but it has default settings for specific file types such as thesis, license agreement, and web page.

---

# TODO
- Study 'Natural language processing'
- add 'processHTML'
- Create UI System

- ##Future Function!##
	- Source's complexity Checker!
	- Need Professional Help.
		* How does people decide which source is more harder than other.
		* What standard could be used to check sentence's complexity.
		 
- ##INSIDE##
	* More Efficiently arrange sentences (Paragraph&Sentence = Tree, Word = HashMap<K=word,V=priority, complexity>)
	
---

#ASSUMPTION

- MySQL database exist
- Internet connection
- Pre-defined synonym vocabulary list = [Thesaurus](http://www.thesaurus.com)
- Source file should be text and well structured (Pharagraph>Sentence>Word)
- Higher priority sentence will use user-selected words more than Lower priority sentence.
- 'Context' will be contained in the same paragraph. (Related or Not)


---

# IDEA
1. Collect Search Result and Analyze it in terms of easy and important information. Reorganize the search result.
2. Extract important sentences from License Agreement.
3. Easy Text : Word's difficulty, How many important sentence are there(ratio),  

---

# Class Definition
- **parseSource** INITAL

"parseSource" is a main class. It deals with processed value, String. The String is already process by Process<Resource>(text, HTML, Search) class. So, what this class do is parsing String into sentences. And reorganize sentences followed by each sentence's priority. Then return sentences to UI.

- **Paragraph** INITIAL

"Paragraph" is a semantic token. It has priority and sentences. It calculates its priority from sentences. It is reorganized according to sentence's priority. 

- **Sentence** INITAL

"Sentence" is a semantic token. It has priority and words. It calculates its priority by words. and store the original sentence in it. It can return its priority and the original sentence.

- **Word** INITIAL

"Word" is a minimum token, which means it does not have meaning itself, but it has priority in order to calculate sentence's priority. it returns priority and word.

- **ProcessText** INITAL

"ProcessText" is a processing class. It takes text file from UI(User) and make it into one large string and pass to UI and then UI pass String to "ParseSource".

- **Voca** INITIAL

"Voca" is a database class. It communicate with database and help to compare a sentence's words to controlled vocabulary. And return word's priority. 

(TIP: priority=0 means the word does not exist in database.)

- **UI**

"UI" is a graphic class and interface with users. It asks what type of source gone a use, help to insert controlled vocabulary into database. and return the result in text format with sentence priority notification.

- **Crawler** INITIAL

"Crawler" is a collecting class. It get a user's word and insert synonyms to database with set priority. This uses [Thesaurus](http://www.thesaurus.com) database to collect synonyms. 

And it could used for check a source's complexity in the future.

---

#Procedure
1. Graphical interface(UI) asks users to what type of source want to analyze.
2. UI sends user's selection to proper process class.
3. process class takes the resource, make it into String format, and then pass String to parsing class.
4. parsing class parses the resource into sentences.
5. parsed sentences will calculate their priority themselves. 
6. Calculating priority method communicate with Voca class and get each words priority and sum up!
7. parsing class reorganizes sentences followed by each sentence's priority.
8. UI will print out reorganized sentences and their priority from parsing class.
9. UI asks to users that add or remove (or satisfy with result) Vocabulary with its priority.
10. after modify vocabulary database restart Procedure.

__Procedure__
UI>Processing>Parsing>Calculating>Reorganizing>UI

---


