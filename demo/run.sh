if [ $# -ne 6 ]; then
    echo "Usage: $0 <image_name> <pdf_name><x><y><width><height>"
    exit 1
fi

image_name=$1
pdf_name=$2
x=$3
y=$4
width=$5
height=$6

mvn clean compile exec:exec -Darg1="$image_name" -Darg2="$pdf_name" -Darg3="$x" -Darg4="$y" -Darg5="$width" -Darg6="$height"