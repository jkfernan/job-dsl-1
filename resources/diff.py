import os
dir = os.path.dirname(os.path.realpath(__file__))

list1 = open(str(dir)+"/plugin_orig.txt").readlines()
list2 = open(str(dir)+"/plugins.txt").readlines()

nameList1 = []
nameList2 = []

for plugin in list1:
    p = plugin.split(":")[0]
    nameList1.append(p)

for plugin2 in list2:
    p2 = plugin2.split(":")[0]
    nameList2.append(p2)

print(nameList1)
print(nameList2)

# prints the missing and additional elements in list2 
print("Missing values in second list:\n", "\n".join(sorted(set(nameList1).difference(nameList2))))
#print("Additional values in second list:", (set(list2).difference(list1)))
  
# prints the missing and additional elements in list1
#print("Missing values in first list:", (set(list2).difference(list1)))
#print("Additional values in first list:", (set(list1).difference(list2)))
