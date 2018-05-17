cp src/main/java/fr/thiiozz/algorithm/unionfind/exercice/Percolation.java ./Percolation.java
cp src/main/java/fr/thiiozz/algorithm/unionfind/exercice/PercolationStats.java ./PercolationStats.java

tail -n +2 Percolation.java > Percolation.java.tmp && mv Percolation.java.tmp Percolation.java
tail -n +2 PercolationStats.java > PercolationStats.java.tmp && mv PercolationStats.java.tmp PercolationStats.java

zip percolation.zip Percolation.java PercolationStats.java

rm PercolationStats.java
rm Percolation.java

mv percolation.zip ~/percolation.zip

echo "Size of ~/percolation.zip = $(stat -c%s ~/percolation.zip) bytes."