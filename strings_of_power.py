
#Returns a list of the occurrences of substr in str
def search(s, sub):
	res = []
	stop = False
	currLoc = 0
	while(True):
		#print(s)
		loc = s.find(sub)
		if(loc >= 0):
			res.append(loc + currLoc)
			s = s[loc + 1:]
			currLoc += loc + 1
		else:
			break
			
	return res
	
if __name__ == '__main__':
	s = input()
	#s = 'heavymetal'*100000
	loc1 = search(s, 'heavy')
	loc2 = search(s, 'metal')
	heavyCount = 0 #total occurrences of 'heavy'
	total = 0 #total substrings found
	heavyPoint = 0
	metalPoint = 0
	while(heavyPoint < len(loc1) and metalPoint < len(loc2)):
		#If metal comes before heavy, we shift the metal pointer and
		#add the previous counts of heavy
		if(loc1[heavyPoint] > loc2[metalPoint]):
			total += heavyCount
			metalPoint += 1
		#If heavy comes before metal, we pop from the heavy list and
		#increment the counts of heavy
		elif(loc2[metalPoint] > loc1[heavyPoint]):
			heavyCount += 1
			heavyPoint += 1
			
	total += heavyCount*(len(loc2) - metalPoint)
		
	print(total)