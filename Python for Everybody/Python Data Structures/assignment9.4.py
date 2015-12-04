name = raw_input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"
handle = open(name)

counts = dict()
for line in handle:
    if line.startswith('From'):
        words = (line.rstrip()).split()
        if len(words) == 7:
            person = words[1]
            counts[person] = counts.get(person, 0) + 1
        
bigTime = None
bigCommitter = None
for key, value in counts.items():
    if bigCommitter == None or value > bigTime:
        bigCommitter = key
        bigTime = value

print bigCommitter, bigTime
        