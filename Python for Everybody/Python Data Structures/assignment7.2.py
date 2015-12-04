# Use the file name mbox-short.txt as the file name
fname = raw_input("Enter file name: ")
fh = open(fname)

sum = 0
count = 0

for line in fh:
    if not line.startswith("X-DSPAM-Confidence:") : continue
    sum += float(line[19:].strip())
    count += 1
    
result = sum / count

print "Average spam confidence:" + " " + str(result)
