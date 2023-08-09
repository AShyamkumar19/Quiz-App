If there are no arguments the program will go to study/quiz mode
to pass on a file you enter "mockSrFile/TestQs.sr" or "sampleTest/testFiles/testFile.sr" or any file
you see on the system
The TestQs.sr file will be in an improper format, so the code will reformat the file so it's ready
to be quizzed on.
The format of the sr file will be like this:
Question:::Answer -Difficulty

What's 22+22?:::44 -Hard
Who's the first president of the United States?:::George Washington -Hard
What is the capital of the United States?:::Washington D.C. -Hard
What element is the most abundant in the air?:::Nitrogen -Hard
What's 2 + 2?:::4 -Easy
What's the capital of California?:::Sacramento -Easy
What's my name?:::John -Hard
What's H:::Hydrogen -Easy
What's He:::Helium -Hard
Who's the richest man in the world? ::: Jeff Bezos -Easy

You can see a formatted sr file in sampleTest/testFiles/testFile.sr

Whether you want to create a file or pass on a file for the program to quiz you on, the program will
reformat the file to the format above. Once the code is done quiz mode, the file you were quizzed on
will have updated.