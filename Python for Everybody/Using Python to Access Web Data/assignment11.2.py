import re

fileName = raw_input('File Name: ')

try:
	handle = open(fileName)
except:
	print 'This file does not exist.'
	exit()

numList = list()
for line in handle:
	line = line.rstrip()
	numbers = re.findall('[0-9]+', line)

	if len(numbers) == 0:	continue

	for number in numbers:
		numList.append(int(number))

print sum(numList)