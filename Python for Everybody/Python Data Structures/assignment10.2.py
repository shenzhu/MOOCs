name = raw_input("Enter file:")
if len(name) < 1 : name = "mbox-short.txt"
handle = open(name)

counts = dict()
for line in handle:
    if line.startswith('From'):
        words = line.rstrip().split()
        if len(words) == 7:
            time = words[5].split(':')
            hour = time[0]
            counts[hour] = counts.get(hour, 0) + 1

hourFreq = sorted(counts.items())
for key, value in hourFreq:
    print key, value