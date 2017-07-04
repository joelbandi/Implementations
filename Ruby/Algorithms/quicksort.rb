def quicksort(array)
  return sort(array,0,array.length-1)
end

def sort(array,left,right)
  return [] if left>=right
  p_index = partition(array,left,right)
  sort(array,left,p_index-1)
  sort(array,p_index+1,right)
  return array
end
def partition(array,left,right)
  p_index = left
  pivot = array[right]
  (left...right).each do |index|
    if array[index] <=pivot
      array[index],array[p_index] = array[p_index],array[index]
      p_index = p_index+1
    end
  end
  array[right],array[p_index] = array[p_index],array[right]
  p_index
end

puts quicksort([5,4,7,1,2,5])
