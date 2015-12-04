text = "X-DSPAM-Confidence:    0.8475";

pos = text.find('0')
textLength = len(text)

resultText = text[pos:textLength]
result = float(resultText)

print result