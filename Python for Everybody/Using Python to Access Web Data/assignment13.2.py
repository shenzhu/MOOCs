import urllib
import xml.etree.ElementTree as ET

address = raw_input('Enter location: ')

url = address
print 'Retrieving', url
uh = urllib.urlopen(url)
data = uh.read()
print 'Retrieved',len(data),'characters'
#print data

tree = ET.fromstring(data)
comments = tree.findall('comments/comment')

numList = list()
for comment in comments:
    number = int(comment.find('count').text)
    numList.append(number)

print 'Count: ', len(numList)
print 'Sum: ', sum(numList)
