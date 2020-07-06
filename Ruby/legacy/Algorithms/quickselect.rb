def quickselect(array,k)
  if array.nil? || array.empty? || k> array.length
    nil
  else
    select(array,0,array.length-1,k)
  end
end

def select(array,left,right,k)
  p_index = partition(array,left,right)
  return array[p_index] if p_index = k-1
  return select(array,p_index+1,right,k) if p_index < k-1
  select(array,left,p_index-1)
end

def partition(array,left,right)
  p_index = left
  pivot = array[right]
  (left...right).each do |i|
    if(array[i] <= pivot)
      array[p_index],array[i] = array[i],array[p_index]
      p_index = p_index+1
    end
  end
  array[right],array[p_index] = array[p_index],array[right]
  p_index
end

puts quickselect [7,5,4,1,2,6,9,8,3],3