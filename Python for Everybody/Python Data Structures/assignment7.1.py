# Use words.txt as the file name
fname = raw_input("Enter file name: ")
fh = open(fname)

for line in fh:
    lineUpper = (line.rstrip()).upper()
    print lineUpper
