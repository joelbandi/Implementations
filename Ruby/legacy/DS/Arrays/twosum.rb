# Given an array of integers return check if there exists any two elements 
# whose sum is a given target and the return an array with two elements' indexes

def twosum(array, target)
  return [] if array.length<=1
  cache = {}
  array.each.with_index do |e,i|
    if cache.include? (target-e)
      return [i,cache[target-e]]
    else
      cache[e] = i
    end
  end
  return []
end

puts twosum [1,2,3,4,5,6,10],16


# Given an array of integers return check if there exists any two elements 
# whose sum is a given target and the return an array with two elements
def twosumtwo(a, target)
  return [] if a.length <= 1
  l = 0;
  r = a.length-1
  a.sort!
  while l < r do
    if a[l] + a[r] == target
      return [a[l],a[r]]
    elsif (a[l] + a[r]) < target
      l = l+1
    else
      r = r+1
    end
  end
end

puts twosumtwo [1,2,3,4,5,6,10],16