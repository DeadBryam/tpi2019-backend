#!/bin/bash
#
#172.18.46.96
SITE="192.168.43.162"
URI="http://$SITE:2608/libreria/wr"
IDSUC="$1"
IDCAJ="$2"
FINDRANGE=("$URI/sucursal" "$URI/sucursal/$IDSUC/caja" "$URI/sucursal/$IDSUC/historial" "$URI/sucursal/$IDSUC/bodega" "$URI/sucursal/$IDSUC/bodega?filter=borrador" "$URI/articulo?filter=borrador")
FINDBYID=("$URI/sucursal/$IDSUC/caja/$IDCAJ" "$URI/sucursal/$IDSUC")

contadorMe=0
contadorFa=0

#se empieza a probar todos los findRange del rest
#FLITROF = filtro de metodo find range
FILTROF="Total-Reg:"
for ((i=0;i<${#FINDRANGE[@]};i++))
   do
     a=${FINDRANGE[$i]};
     echo $a
     result=`curl -v -sS  2>&1>/dev/null $a | egrep '('Total'|'Page')' | cut -c 3-16 `
      b=`curl -v -sS  2>&1>/dev/null $a | grep 'Total' | cut -c 3-12`
	if [ "$b" == "$FILTROF" ];
           then 
       		echo "correcto"
		let contadorMe=contadorMe+1
		echo "$result"
        else
       		echo "fallo"
		echo "$result"
		let contadorFa=contadorFa+1
       fi
     echo -e "\n"
done

#se empieza a probar todos los findById del rest

#FLITROFB = filtro de metodo find by id
FILTROFB="Registro Encontrado: 1"

for ((i=0;i<${#FINDBYID[@]};i++))
   do
     a=${FINDBYID[$i]};
     echo $a
     result=`curl -v -sS  2>&1>/dev/null $a |egrep 'Registro' |cut -c 3-24`
	if [ "$result" == "$FILTROFB" ];
   	   then 
       		echo "correcto"
		let contadorMe=contadorMe+1
        else
       		echo "fallo"
		let contadorFa=contadorFa+1
        fi
     echo -e "\n"
done

echo "METODOS CORRECTOS: $contadorMe"
echo "METODOS INCORRECTOS: $contadorFa"

if [ $contadorFa != 0 ];
	then
		echo "Error!, algo anda mal" 1>&2
		exit 1
	fi
