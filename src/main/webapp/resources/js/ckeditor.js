/* CKEditor 설정 파일 */

ClassicEditor 
.create( document.querySelector( '#content' ) )
.then( editor => { 
    console.log( editor ); 
} ) 
.catch(error => { 
    console.error( error ); 
});



