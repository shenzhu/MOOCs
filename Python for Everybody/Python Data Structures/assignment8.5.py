fname = raw_input("Enter file name: ")
if len(fname) < 1 : fname = "mbox-short.txt"

fh = open(fname)
count = 0

for line in fh:
    if line.rstrip().startswith('From'):
        words = line.split()
        if len(words) == 7:
            address = words[1]
            print address
            
            count += 1            
        
print "There were", count, "lines in the file with From as the first word"