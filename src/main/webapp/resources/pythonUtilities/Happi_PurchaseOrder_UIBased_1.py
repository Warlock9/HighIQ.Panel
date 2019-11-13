import PyPDF2
from PyPDF2 import PdfFileWriter, PdfFileReader
import os
import comtypes.client
import pdfkit
import csv
import time
import io
from PIL import Image
import pytesseract
from wand.image import Image as wi
import shutil
import os.path
import glob
import sys
import datetime
from shutil import copyfile
from PyPDF2 import PdfFileMerger
from difflib import get_close_matches 
import configparser
import subprocess
import sys
import numpy as np
import pikepdf
pytesseract.pytesseract.tesseract_cmd = 'C:\\Program Files\\Tesseract-OCR\\tesseract.exe'

def decryptingFile(decrypt_FilePath,decrypt_FileName):

		global DecryptingPath
		global ERROR_DESCRIPTION_INFO_DECRYPT
		DecryptingPath=os.path.join("Decrypting")
		if not os.path.exists(DecryptingPath):
			os.makedirs(DecryptingPath)
		
		try:
			tempfilepath=os.path.join(DecryptingPath,decrypt_FileName)


			pdf = pikepdf.open(decrypt_FilePath)
			pdf.save(tempfilepath)
			#subprocess.run(["qpdf", "--decrypt", decrypt_FilePath, tempfilepath])

		except Exception as e:
			print(e)


def creatingPaths(TempPath,flagNo):
	print("Creating paths has been entered")
	C_Drive_Path=r"C:\\"
	D_Drive_Path=r"D:\\"
	E_Drive_Path=r"E:\\"
	global inputPath
	global outputPath
	global temporaryFilePath
	global workingPath
	global correct_Extension_Folder_Path

	workingPath="working"
	correct_Extension_Folder="CorrectExtension"
	correct_Extension_Folder_Path=os.path.join(workingPath,correct_Extension_Folder)
	
	if not os.path.exists(workingPath):
		os.makedirs(workingPath)
	if not os.path.exists(correct_Extension_Folder_Path):
		os.makedirs(correct_Extension_Folder_Path)
	temp_path=TempPath.split("\\")
	#print(temp_path[0])
	if flagNo==1:
		print("Creating Paths: 1")
		inputPath=r""
		if temp_path[0] in C_Drive_Path:
			inputPath=os.path.join(inputPath,C_Drive_Path)
		elif temp_path[0]in D_Drive_Path:
			inputPath=os.path.join(inputPath,D_Drive_Path)
		elif temp_path[0]in E_Drive_Path:
			inputPath=os.path.join(inputPath,E_Drive_Path)
		for x in temp_path:
			if not x=="C:" or x=="D:" or x=="E:":
				#print(x)
				inputPath=os.path.join(inputPath,x)
     
	elif flagNo==2:
		print("Creating Paths 2")
		outputPath=r""
		if temp_path[0] in C_Drive_Path:
			outputPath=os.path.join(outputPath,C_Drive_Path)
		elif temp_path[0]in D_Drive_Path:
			outputPath=os.path.join(outputPath,D_Drive_Path)
		elif temp_path[0]in E_Drive_Path:
			outputPath=os.path.join(outputPath,E_Drive_Path)
		for x in temp_path:
			if not x=="C:" or x=="D:" or x=="E:":
				#print(x)
				outputPath=os.path.join(outputPath,x)
	elif flagNo==3:
		print("Creating Paths 3")
		temporaryFilePath=r""
		if temp_path[0] in C_Drive_Path:
			temporaryFilePath=os.path.join(temporaryFilePath,C_Drive_Path)
		elif temp_path[0]in D_Drive_Path:
			temporaryFilePath=os.path.join(temporaryFilePath,D_Drive_Path)
		elif temp_path[0]in E_Drive_Path:
			temporaryFilePath=os.path.join(temporaryFilePath,E_Drive_Path)
		for x in temp_path:
			if not x=="C:" or x=="D:" or x=="E:":
				#print(x)
				temporaryFilePath=os.path.join(temporaryFilePath,x)
	


def initializingPaths():
	print("initializingPaths has started")
	
	config = configparser.ConfigParser()
	print("initializing config parser")
	config.read(r"D:\WebApp_Hosting\Host_Steris_8084\webapps\HighIQ.ai\resources\pythonUtilities\configUI.txt")
	var_inputPath = config.get("myPaths", "inputPath")
	var_outputPath = config.get("myPaths", "outputPath")
	var_temporaryFiles=config.get("myPaths", "temporaryFilePath")
	creatingPaths(var_inputPath,1)
	print("Created Input Path Successfully")
	creatingPaths(var_outputPath,2)
	print("Created Output Path Successfully")
	creatingPaths(var_temporaryFiles,3)
	print("Created Temporary Paths Successfully")
def deletingTempFiles():
		files1=os.listdir(temporaryFilePath)
		for f in files1:
			path1=os.path.join(temporaryFilePath,f)
			try:
				#winshell.delete_file(filepath)
				os.remove(path1)
				print("Removed "+str(f)+"\n\n")
			except Exception as e:
				tempok=1
				#print(str(e)+"\n\n")
				#print(" ")

def SplittingPdf(split_FileName):
	global desiredOutputPath
	global splitFolderPath
	global classifiedFolderPath
	global workingFolderPath
	global SplitPdfFilesNames
	global orientationFolderPath
	global outputFolderPath
	tempFileName=split_FileName.rsplit(".")
	if typeOfOutput==2:
		desiredOutputPath=os.path.join(JPEGFolderPath,tempFileName[0])
		os.makedirs(desiredOutputPath)
	elif typeOfOutput==3:
		desiredOutputPath=os.path.join(PNGFolderPath,tempFileName[0])
		os.makedirs(desiredOutputPath)

	elif typeOfOutput==4:
		desiredOutputPath=os.path.join(TIFFFolderPath,tempFileName[0])
		os.makedirs(desiredOutputPath)
	workingFolderPath=os.path.join(workingPath,tempFileName[0])
	splitFolder=tempFileName[0]+"_Splitting"
	splitFolderPath=os.path.join(workingFolderPath,splitFolder)
	if not os.path.exists(splitFolderPath):
		os.makedirs(splitFolderPath)
	outputFolderPath=os.path.join(outputPath,tempFileName[0])
	if not os.path.exists(outputFolderPath):
		os.makedirs(outputFolderPath)
	orientationFolder=tempFileName[0]+"_Orientation"
	orientationFolderPath=os.path.join(workingFolderPath,orientationFolder)
	if not os.path.exists(orientationFolderPath):
		os.makedirs(orientationFolderPath)
	classifiedFolder=tempFileName[0]+"_Classified"
	classifiedFolderPath=os.path.join(workingFolderPath,classifiedFolder)
	if not os.path.exists(classifiedFolderPath):
		os.makedirs(classifiedFolderPath)
	inputPath_Filename=os.path.join(DecryptingPath,split_FileName)
	with open(inputPath_Filename,'rb')as f:
		fileHandles.append(f)
		pdf=PdfFileReader(f)
		for i in range(pdf.numPages):
			output = PdfFileWriter()
			output.addPage(pdf.getPage(i))
			SplitFileName=tempFileName[0]+"_PageNo_"+str(i+1000)+".pdf"
			splitFilePath=os.path.join(splitFolderPath,SplitFileName)
			with open(splitFilePath, "wb") as outputStream:
				fileHandles.append(outputStream)
				output.write(outputStream)
	SplitPdfFilesNames = os.listdir(splitFolderPath)
	#print(len(SplitPdfFilesNames))





def classification_ExtractedData(extractData,orient_FilePath,orientation_FileName):
	print("Entered into classification module")
	#print(orientation_FileName)
	#print(extractData)
	containsClassified=0
	containsNegative=0
	for x in classified_keyword:
		if x.lower() in extractData.lower():
			print("----------------")
			print(x)
			containsClassified=containsClassified+1
	print("---x---x----x----x----x---x---x----x")
			
	print("\n classified words are as followss: "+str(containsClassified))
	for x in redundant_keyword:
		if x.lower() in extractData.lower():
			print("----------------")
			print(x)
			containsNegative=containsNegative+1
	if "cover page" in extractData.lower():
		print("Contains Cover Page")
		containsNegative=containsNegative+10
	elif "cover" in extractData.lower():
		print("Contains Cover Page")
		containsNegative=containsNegative+10
	for x in total_keyword:
		if x in extractData.lower():
			containsNegative=0


	print("\n negative words are as followss: "+str(containsNegative))
	isCompletedOnSamePage=0
	if "purchase order" in extractData.lower() or "po" in extractData.lower():
		if containsNegative<2:

			print("purchase order present")
			if containsClassified>=10:
				for x in total_keyword:
					if x.lower() in extractData.lower():
						print("\n The PO IS COMPLETE\n -----------\n")
						isCompletedOnSamePage=1
						break

				if isCompletedOnSamePage==0:
					print("\n The PO IS IN---COMPLETE\n -----------\n")

				ExtractedData.append(extractData)
				poCount=0
				
				for pokeyvalue in po_keyword:
					if pokeyvalue in extractData.lower():
						#print(pokeyvalue)
						poCount+=1
				print("The number of Purchse Order keywords in this file is"+str(poCount))
				if poCount>=3:
					isPurchaseOrderPresent.append(1)
					nameOfSplitFile.append(orientation_FileName)
					if isCompletedOnSamePage==1:
						isComplete.append(1)
					else:
						isComplete.append(2)
				else:
					print("Cannot classify the page")
					#isPurchaseOrderPresent.append(0)
					#nameOfSplitFile.append("NA")
				finalfilename=orient_FilePath
				shutil.copy(finalfilename, classifiedFolderPath)
			else:
				print("Page has not been classified\n")




def checkingExtension(x):
		print("Entered the checking Extension")
		extension_html_pdf_doc=['.html','.htm','.shtml','.xhtml','.phtml','.pdf','.doc','.docx']
		equivalent_html_pdf_doc_code=[1,1,1,1,1,2,3,3]
		filename, file_extension = os.path.splitext(x)
		file_matched_extension=get_close_matches(file_extension,extension_html_pdf_doc)
		#print(len(file_matched_extension))
		if len(file_matched_extension)>0:
			file_matched_index=0
			for i in range(0,len(extension_html_pdf_doc)):
				if extension_html_pdf_doc[i]==file_matched_extension[0]:
					file_matched_index=i
					break
			#print(equivalent_html_pdf_doc_code[file_matched_index])
			if equivalent_html_pdf_doc_code[file_matched_index]==1:
				#LogFileOpen.write("\t"+str(datetime.datetime.now())+" : Beginning Process : "+str(filename)+" : Converting HTML to PDF\n")

				inputFilePath=os.path.join(inputPath,x)
				outputFileName=filename+".pdf"
				outputFilePath=os.path.join(correct_Extension_Folder_Path,outputFileName)
				pdfkit.from_file(inputFilePath,outputFilePath)
			elif equivalent_html_pdf_doc_code[file_matched_index]==2:
				inputFilePath=os.path.join(inputPath,x)
				outputFileName=x
				outputFilePath=os.path.join(correct_Extension_Folder_Path,outputFileName)
				shutil.copyfile(inputFilePath,outputFilePath)
			elif equivalent_html_pdf_doc_code[file_matched_index]==3:
				#LogFileOpen.write("\t"+str(datetime.datetime.now())+" : Beginning Process : "+str(filename)+" : Converting doc to PDF \n")
				inputFilePath=os.path.join(inputPath,x)
				outputFileName=filename+".pdf"
				wdFormatPDF=17
				outputFilePath=os.path.join(correct_Extension_Folder_Path,outputFileName)
				word = comtypes.client.CreateObject('Word.Application')
				doc = word.Documents.Open(inputFilePath)
				doc.SaveAs(outputFilePath, FileFormat=wdFormatPDF)
				doc.Close()
				word.Quit()



def keywordList():
	print("Entered the Keyword List method")
	global classified_keyword
	global po_keyword
	global total_keyword
	global redundant_keyword
	global orientation_keyword
		
	allKeywordsFileOpen= open(r'D:\WebApp_Hosting\Host_Steris_8084\webapps\HighIQ.ai\resources\pythonUtilities\keywordUI.txt', "r")
	print("Readiing the keywords for file")
	allKeyword = []
	for c in allKeywordsFileOpen:
	    hello = c.strip()
	    allKeyword.append(hello)
	classified_keyword=[]
	
	total_keyword=[]
	
	orientation_keyword=[]
	keywordIndex=0
	lenOfKeywords=len(allKeyword)
	for x in range (0,len(allKeyword)):
		if not allKeyword[x]=="8888888888":
			classified_keyword.append(allKeyword[x])
			keywordIndex=x
		else:
			break
	if keywordIndex<lenOfKeywords:
		for x in range(keywordIndex+2,len(allKeyword)):
			if not allKeyword[x]=="8888888888":
				total_keyword.append(allKeyword[x])
				keywordIndex=x
			else:
				break
		if keywordIndex<len(allKeyword):
			for x in range(keywordIndex+2,len(allKeyword)):
				if not allKeyword[x]=="8888888888":
					orientation_keyword.append(allKeyword[x])
					keywordIndex=x
				else:
					break

	
def merge_images_vertically(imgs,imageOutputPath):
    '''
    This function merges images vertically
    '''
    #create two lists - one for heights and one for widths
    widths, heights = zip(*(i.size for i in imgs))
    width_of_new_image = min(widths)  #take minimum width
    height_of_new_image = sum(heights)
    # create new image
    new_im = Image.new('RGB', (width_of_new_image, height_of_new_image))
    new_pos = 0
    for im in imgs:
        new_im.paste(im, (0, new_pos))
        new_pos += im.size[1] #position for the next image
    new_im.save(imageOutputPath)


def correctOrientationProc(orientation_FileName):
	global Rotated_FolderPath
	global imagePath
	global imagePath1
	global imageName
	global imageName1
	Rotated_FolderPath="Rotated"
	if not os.path.exists(Rotated_FolderPath):
		os.makedirs(Rotated_FolderPath)
	global extractData
	tryingCount=1
	correctOri=0
	OrientationDegrees=-1
	temp_filename=orientation_FileName.rsplit(".",1)
	while(tryingCount<=4):
		if correctOri==0:
			if tryingCount==1:
				ORIENTATION_FILENAME=orientation_FileName
				orient_FilePath=os.path.join(splitFolderPath,orientation_FileName)
				try:
					pdf = wi(filename=orient_FilePath, resolution=450)
					pdfImage = pdf.convert('jpeg')
				except Exception as e:
					time.sleep(15)
					pdf = wi(filename=orient_FilePath, resolution=450)
					pdfImage = pdf.convert('jpeg')
				imageBlobs = []
				for img in pdfImage.sequence:
					imgPage = wi(image=img)
					try:
						imageBlobs.append(imgPage.make_blob('jpeg'))
					except Exception as e:
						print(e)

				var = []
				for imgBlob in imageBlobs:
					im = Image.open(io.BytesIO(imgBlob))
					text = pytesseract.image_to_string(im, lang='eng')
					var.append(text)
					if not typeOfOutput ==1:
						imageName=temp_filename[0]+desiredExtensionOutput
						imagePath=os.path.join(desiredOutputPath,temp_filename[0]+desiredExtensionOutput)
						im.save(imagePath)
					im.close()
				extractData= str(var)
				extractData=extractData.replace('\\n',' ')
				extractData=extractData.lower()
				global f
				f=open(orient_FilePath,"rb")
				pdf=PdfFileReader(f)
				pageObj=pdf.getPage(0)
				pdf_writer=PdfFileWriter()
				OrientationDegrees = pageObj.get('/Rotate')
				temp_degree=0
				if OrientationDegrees==0:
					temp_degree=1
				elif OrientationDegrees==90:
					temp_degree=1
				elif OrientationDegrees==180:
					temp_degree=0
				elif OrientationDegrees==270:
					temp_degree=0
				else:
					temp_degree=1


				if temp_degree==1:
					pdf_writer=PdfFileWriter()
					imageName1=temp_filename[0]+"_rotated_1"+desiredExtensionOutput
					filename=temp_filename[0]+"_rotated_1.pdf"
					filename=os.path.join(Rotated_FolderPath,filename)
					RotatedForced90_name=filename
					pageObj.rotateClockwise(270)
					pdf_writer.addPage(pageObj)
					newFile = open(filename, 'wb') 
					fileHandles.append(newFile)
					pdf_writer.write(newFile) 
					newFile.close()
					#tryingCount=2
				

					try:
						pdf = wi(filename=filename, resolution=450)
						pdfImage = pdf.convert('jpeg')
					except Exception as e:
						time.sleep(15)
						pdf = wi(filename=filename, resolution=450)
						pdfImage = pdf.convert('jpeg')
					imageBlobs = []
					for img in pdfImage.sequence:
						imgPage = wi(image=img)
						try:
							imageBlobs.append(imgPage.make_blob('jpeg'))
						except Exception as e:
							print(e)

					var = []
					for imgBlob in imageBlobs:
						im = Image.open(io.BytesIO(imgBlob))
						text = pytesseract.image_to_string(im, lang='eng')
						var.append(text)
						if not typeOfOutput ==1:
							imagePath1=os.path.join(desiredOutputPath,imageName1)

							im.save(imagePath1)
						im.close()
					extractData1= str(var)
					extractData1=extractData1.replace('\\n',' ')
					extractData1=extractData1.lower()
					mainCount=0
					rotatedCount=0
					#print(extractData)
					for index in range(0,len(orientation_keyword)):
						if orientation_keyword[index].lower() in extractData.lower():
							mainCount=mainCount+1
					#print(mainCount)
					#print("---------------")
					#print(extractData1)

					for index in range(0,len(orientation_keyword)):
						if orientation_keyword[index].lower() in extractData1.lower():
							rotatedCount=rotatedCount+1
					#print(rotatedCount)
					if rotatedCount>=mainCount:
						tryingCount=2
						extractData=extractData1
						print("Forcefully rotating the page by 270 degrees")


				

				
			else:
				imageName1=temp_filename[0]+"_rotated_"+str(tryingCount-1)+desiredExtensionOutput
				filename=temp_filename[0]+"_rotated_"+str(tryingCount-1)
				filename=filename+".pdf"
				FILENAME=filename
				filename=os.path.join(Rotated_FolderPath,filename)
				try:
					pdf = wi(filename=filename, resolution=450)
					pdfImage = pdf.convert('jpeg')
				except:
					iserror=1
					noOfTries=1
					while (iserror==1 and noOfTries<=3):
						try:
							iserror=0
							time.sleep(5)
							pdf = wi(filename=filename, resolution=450)
							pdfImage = pdf.convert('jpeg')
						except:
							noOfTries=noOfTries+1
							iserror=1
							time.sleep(5)
				imageBlobs = []
				for img in pdfImage.sequence:
					imgPage = wi(image=img)
					try: 
						imageBlobs.append(imgPage.make_blob('jpeg'))	
					except Exception as e:
						print(e)

				var = []
				for imgBlob in imageBlobs:
					im = Image.open(io.BytesIO(imgBlob))
					text = pytesseract.image_to_string(im, lang='eng')
					var.append(text)
					if not typeOfOutput ==1:
						imagePath1=os.path.join(desiredOutputPath,imageName1)
						im.save(imagePath1)
					im.close()
				extractData= str(var)

			filename1=temp_filename[0]+"_rotated_"+str(tryingCount-1)+".pdf"
			extractData=extractData.replace("\\n"," ")
			keywordFound=0
			for index in range(0,len(orientation_keyword)):
				if orientation_keyword[index].lower() in extractData.lower():
					keywordFound=1
					correctOri=1
					break
			if keywordFound==0:
				degree=90
				pageObj.rotateClockwise(degree) 
				#print(pageObj.extractText())
				output = PdfFileWriter()
				output.addPage(pageObj)
				temp=orient_fileName.rsplit(".",1)
				filename1=temp[0]+"_rotated_"+str(tryingCount)+".pdf"
				filename=os.path.join(Rotated_FolderPath,filename1)
				newFile = open(filename, 'wb') 
				output.write(newFile) 
				newFile.close()
				f.close()
				f = open(filename, "rb")
				fileHandles.append(f)
				pdf = PdfFileReader(f)
				pageObj = pdf.getPage(0)
				
				tryingCount=tryingCount+1
				
			if (keywordFound==1 or tryingCount==6):
				finalfilename=""
				if tryingCount==1 or tryingCount ==6:
						if not typeOfOutput==1:
							shutil.copy(imagePath,orientationFolderPath)
							finalfilename=imagePath
							classification_ExtractedData(extractData,imagePath,imageName)
						else:
							shutil.copy(orient_FilePath, orientationFolderPath)
							finalfilename=orient_FilePath
							classification_ExtractedData(extractData,orient_FilePath,orientation_FileName)
						f.close()
						break
				else:
					
					im.close()
					if not typeOfOutput==1:
						shutil.copy(imagePath1,orientationFolderPath)
						finalfilename=imagePath1
						classification_ExtractedData(extractData,imagePath1,imageName1)
					else:

						shutil.copy(filename,orientationFolderPath)
						finalfilename=filename
						classification_ExtractedData(extractData,filename,filename1)
					f.close()
				
					
					break
				
				
			



print("Starting initializingPaths")
initializingPaths()
keywordList()
temp_path=r""
#The output parameter must be the first argument which should be passed
print(sys.argv)
po_keyword=[]
redundant_keyword=[]
typeOfOutput=0
ClassifiedData=[]
#print(typeOfOutput1)
fileList=os.listdir(inputPath)
for x in fileList:
	print("Checking Extension ")
	checkingExtension(x)
desiredExtensionOutput=""
try:
	typeOfOutput1=sys.argv[1]
	tempKeywords=sys.argv[2]
	if typeOfOutput1=="1":
		typeOfOutput=1
		print("Desired Output format is PDF")
	elif typeOfOutput1=="2":
		typeOfOutput=2
		print("Desired Output format is JPEG")
		desiredExtensionOutput=".jpg"
		
		JPEGFolderPath=os.path.join("JPEG")
		temp_path=JPEGFolderPath
		if not os.path.exists(JPEGFolderPath):
			os.makedirs(JPEGFolderPath)
	elif typeOfOutput1=="3":
		typeOfOutput=3
		PNGFolderPath=os.path.join("PNG")
		desiredExtensionOutput=".png"
		if not os.path.exists(PNGFolderPath):
			os.makedirs(PNGFolderPath)
		temp_path=PNGFolderPath
		print("Desired Output format is PNG")
	elif typeOfOutput1=="4":
		typeOfOutput=4
		desiredExtensionOutput=".tiff"
		TIFFFolderPath=os.path.join("TIFF")
		if not os.path.exists(TIFFFolderPath):
			os.makedirs(TIFFFolderPath)
		temp_path=TIFFFolderPath
		print("Desired Output format is TIFF")


	temp_keyword=tempKeywords.split("1818")
	temp_POkeyword=temp_keyword[0].split("88")
	for temp_key in temp_POkeyword:
		po_keyword.append(temp_key)
	print(po_keyword)
	temp_Negavtivekeyword=temp_keyword[1].split("88")
	for temp_key in temp_Negavtivekeyword:
		redundant_keyword.append(temp_key)
	print(redundant_keyword)



except:
	print("No argument Received! Output format set to Default - PDF")
	typeOfOutput=1

fileList=os.listdir(correct_Extension_Folder_Path)
for x in fileList:
	extension_file_path=os.path.join(correct_Extension_Folder_Path,x)
	decryptingFile(extension_file_path,x)

for x in fileList:
	deletingTempFiles()
	fileHandles=[]
	ExtractedData=[]
	isPurchaseOrderPresent=[]
	nameOfSplitFile=[]
	isComplete=[]
	SplittingPdf(x)
	for pages in SplitPdfFilesNames:
		correctOrientationProc(pages)


	print("--------------------")
	#print(len(ExtractedData))
	#print(ExtractedData)
	print(isPurchaseOrderPresent)
	print(nameOfSplitFile)
	print(isComplete)
	FileNamesOrient=os.listdir(orientationFolderPath)
	writtenInOutput=[]
	for index in range(0,len(FileNamesOrient)):
		writtenInOutput.append(0)
	PO_Count_No=0
	for isPresent in range(0,len(isPurchaseOrderPresent)):
		#print("Entered "+str(isPresent))
		if isPurchaseOrderPresent[isPresent]==1:
			PO_Count_No=PO_Count_No+1
			if isComplete[isPresent]==1:
				#print("Entered the isComplete = 1 ")

				tempFileData=nameOfSplitFile[isPresent]
				input_Temp_File_Path=os.path.join(classifiedFolderPath,nameOfSplitFile[isPresent])
				tempName=tempFileData.split("_PageNo_")
				renamingFileName=""
				if not typeOfOutput==1:
					renamingFileName=tempName[0]+"_PO_"+str(PO_Count_No)+desiredExtensionOutput
				else:
					renamingFileName=tempName[0]+"_PO_"+str(PO_Count_No)+".pdf"
				renamingFilePath=os.path.join(outputFolderPath,renamingFileName)
				for fileIndex in range(0,len(FileNamesOrient)):
					if nameOfSplitFile[isPresent]==FileNamesOrient[fileIndex]:
						if writtenInOutput[fileIndex]==0:
							shutil.copyfile(input_Temp_File_Path,renamingFilePath)
							writtenInOutput[fileIndex]=1
						else:
							PO_Count_No=PO_Count_No-1
			else:
				#print("Entered the isComplete = 2 ")
				input_Temp_File_Path=os.path.join(classifiedFolderPath,nameOfSplitFile[isPresent])

				findingFileList=os.listdir(orientationFolderPath)
				file2find=nameOfSplitFile[isPresent]
				#print("Finding the file "+str(file2find))
				tempName=file2find.split("_PageNo_")
				foundindex=-1
				#print("List of files is as follows")
				#print(findingFileList)
				for index in range(0,len(findingFileList)):
					if file2find==findingFileList[index]:
						foundindex=index+1
				#		print("Index "+str(index))
				#		print("Continuing Page Index "+str(foundindex))
				if not foundindex==-1 and foundindex<len(findingFileList):
					for fileIndex in range(0,len(FileNamesOrient)):
						if nameOfSplitFile[isPresent]==FileNamesOrient[fileIndex]:
							if writtenInOutput[fileIndex]==0:
								writtenInOutput[fileIndex]=1
							if writtenInOutput[foundindex]==0:
								writtenInOutput[foundindex]=1

					page1=os.path.join(orientationFolderPath,nameOfSplitFile[isPresent])
					page2=os.path.join(orientationFolderPath,findingFileList[foundindex])
					shutil.copy(page2, classifiedFolderPath)
					renamingFileName=tempName[0]+"_PO_"+str(PO_Count_No)+".pdf"
					renamingFilePath=os.path.join(outputFolderPath,renamingFileName)
					if typeOfOutput==1:
						merginFileList=[]
						merginFileList.append(page1)
						merginFileList.append(page2)
						merger = PdfFileMerger()
						for pageName in merginFileList:
							merger.append(pageName)
						merger.write(renamingFilePath)
					else:
						renamingFileName=tempName[0]+"_PO_"+str(PO_Count_No)+desiredExtensionOutput
						renamingFilePath=os.path.join(outputFolderPath,renamingFileName)
						imageList=[]
						imageList.append(page1)
						imageList.append(page2)
						imgs = [Image.open(im) for im in imageList]
						merge_images_vertically(imgs,renamingFilePath)
					

				else:
					if typeOfOutput==1:
						renamingFileName=tempName[0]+"_PO_"+str(PO_Count_No)+".pdf"
						renamingFilePath=os.path.join(outputFolderPath,renamingFileName)
						shutil.copyfile(input_Temp_File_Path,renamingFilePath)
					else:
						renamingFileName=tempName[0]+"_PO_"+str(PO_Count_No)+desiredExtensionOutput
						renamingFilePath=os.path.join(outputFolderPath,renamingFileName)
						shutil.copyfile(input_Temp_File_Path,renamingFilePath)

	for fh in fileHandles:
		#print(fh)
		fh.close()				


try:
	shutil.rmtree(Rotated_FolderPath)
except Exception as e:
	print(e)
try:
	shutil.rmtree(DecryptingPath)
except Exception as e:
	print(e)
folders=os.listdir(workingPath)
for x in folders:
	path1=os.path.join(workingPath,x)
	try:
		shutil.rmtree(path1)
	except Exception as e:
		print(e)	
try:
	shutil.rmtree(workingPath)
except Exception as e:
	print(e)	
try:
	shutil.rmtree(desiredOutputPath)
except Exception as e:
	print(e)	

if os.path.exists(temp_path):
	try:
		shutil.rmtree(temp_path)
	except Exception as e:
		print(e)