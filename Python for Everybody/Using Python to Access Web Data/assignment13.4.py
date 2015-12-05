import urllib
import json

url = raw_input('Enter location: ')
print 'Retrieving ', url
data = urllib.urlopen(url).read()
print 'Retrieved', len(data),'characters'
info = json.loads(data)
#print json.dumps(info, indent = 4)
comments = info["comments"]

numList = list()
for comment in comments:
    number = int(comment["count"])
    numList.append(number)

print 'Count: ', len(comments)
print 'Sum: ', sum(numList)
